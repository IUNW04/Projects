from django.contrib import admin
from .models import Item, ItemType, ItemStatus

# Register your models here.

admin.site.register(Item)
admin.site.register(ItemType)
admin.site.register(ItemStatus)