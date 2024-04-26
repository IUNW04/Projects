from django.shortcuts import render, redirect, get_object_or_404
from django.contrib import messages
from django.db.models import Q
from .models import Item, ItemType, ItemStatus, Booking
from .forms import BookingForm
from django.contrib.auth.decorators import login_required
from django.utils import timezone


def equipmentView(request):
    itemtypes = ItemType.objects.all()
    itemstatus = ItemStatus.objects.all()

    q = request.GET.get('q') if request.GET.get('q') != None else ""
    status_filter = request.GET.get('status')
    type_filter = request.GET.get('type')
    sort_by = request.GET.get('sort')

    items = Item.objects.filter(
        Q(type__type__icontains=q) |
        Q(name__icontains=q) |
        Q(deviceSerialNumber__icontains=q) |
        Q(CPU__icontains=q) |
        Q(GPU__icontains=q) |
        Q(RAM__icontains=q) |
        Q(location__icontains=q) |
        Q(status__status__icontains=q)
    )

    if status_filter:
        items = items.filter(status__status=status_filter)
    if type_filter:
        items = items.filter(type__type=type_filter)
    if sort_by:
        items = items.order_by(sort_by)

    totalInventory = items.count()

    context = {'items': items, 'itemtypes': itemtypes, 'itemstatus': itemstatus, 'totalInventory': totalInventory}
    return render(request, 'appone/equipmentView.html', context)

@login_required
def book_item(request, item_id):
    item = get_object_or_404(Item, pk=item_id)

    if request.method == 'POST':
        form = BookingForm(request.POST)
        if form.is_valid():
            booking = form.save(commit=False)
            booking.item = item
            booking.user = request.user
            booking.save()
            # Check if item.quantity is not None before converting it to an integer
            if item.quantity is not None:
                item.quantity = int(item.quantity)
                item.quantity -= 1
                item.save()  # Save the updated item
            messages.success(request, 'Equipment booked successfully!')
            return redirect('bookings_view')
        else:
            for field, errors in form.errors.items():
                for error in errors:
                    messages.error(request, f"{field}: {error}")
    else:
        form = BookingForm()

    return render(request, 'appone/booking_form.html', {'form': form, 'item': item})




@login_required
def bookings_view(request):
    current_bookings = Booking.objects.filter(user=request.user, end_date__gte=timezone.now().date())
    return render(request, 'appone/bookings.html', {'bookings': current_bookings})

def historical(request):
    historical_bookings = Booking.objects.filter(end_date__lt=timezone.now().date())
    return render(request, 'appone/historical.html', {'historical_bookings': historical_bookings})

@login_required
def rebook(request, item_id):
    item = get_object_or_404(Item, pk=item_id)

    if request.method == 'POST':
        form = BookingForm(request.POST)
        if form.is_valid():
            booking = form.save(commit=False)
            booking.item = item
            booking.user = request.user
            booking.save()
            # Check if item.quantity is not None before converting it to an integer
            if item.quantity is not None:
                item.quantity = int(item.quantity)
                item.quantity -= 1
                item.save()  # Save the updated item
            messages.success(request, 'Equipment rebooked successfully!')
            return redirect('bookings_view')
        else:
            for field, errors in form.errors.items():
                for error in errors:
                    messages.error(request, f"{field}: {error}")
    else:
        form = BookingForm()

    return render(request, 'appone/booking_form.html', {'form': form, 'item': item})




@login_required
def cancel_booking(request, booking_id):
    booking = get_object_or_404(Booking, pk=booking_id)
    if request.method == 'POST':
        booking.delete()
        messages.success(request, 'Booking canceled successfully!')
        return redirect('bookings_view')
    return HttpResponseRedirect(request.META.get('HTTP_REFERER'))
