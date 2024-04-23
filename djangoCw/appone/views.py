
# path: /Users/imadhuddin/Desktop/djangoCw/appone/views.py

from django.shortcuts import render, redirect
from django.contrib import messages  
from .models import Item, ItemType, ItemStatus
from .forms import CreateItemForm, UpdateItemForm
from django.db.models import Q
from django.contrib.auth.decorators import login_required
from django.utils import timezone
from django.shortcuts import get_object_or_404
from .models import Booking
from .forms import BookingForm
from django.shortcuts import render, redirect, get_object_or_404
from django.shortcuts import render, redirect







def equipmentView(request):
    itemtypes = ItemType.objects.all()
    itemstatus = ItemStatus.objects.all()

    q = request.GET.get('q') if request.GET.get('q') != None else ""
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
    totalInventory = items.count()

    context = {'items': items, 'itemtypes': itemtypes, 'itemstatus': itemstatus, 'totalInventory': totalInventory}
    return render(request, 'appone/equipmentView.html', context)



from django.contrib import messages

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
            messages.success(request, 'Equipment booked successfully!')
            return redirect('bookings_view')
        else:
            # If the form is not valid, display error messages
            for field, errors in form.errors.items():
                for error in errors:
                    messages.error(request, f"{field}: {error}")
    else:
        form = BookingForm()
    
    return render(request, 'appone/booking_form.html', {'form': form, 'item': item})



@login_required
def bookings_view(request):
    bookings = Booking.objects.filter(user=request.user)
    return render(request, 'appone/bookings.html', {'bookings': bookings})