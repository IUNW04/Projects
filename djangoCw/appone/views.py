
# path: /Users/imadhuddin/Desktop/djangoCw/appone/views.py

from django.shortcuts import render, redirect
from django.contrib import messages  # Add this import
from .models import Item, ItemType, ItemStatus
from .forms import CreateItemForm, UpdateItemForm
from django.db.models import Q
from django.contrib.auth.decorators import login_required
from django.utils import timezone
from django.shortcuts import get_object_or_404
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


