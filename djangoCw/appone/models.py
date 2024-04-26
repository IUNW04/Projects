# path: /Users/imadhuddin/Desktop/djangoCw/appone/models.py

from django.db import models
from django.contrib.auth.models import User


class Item(models.Model):
    deviceSerialNumber = models.CharField(max_length=50, null=True, blank=True)
    name = models.CharField(max_length=50)
    type = models.ForeignKey('ItemType', on_delete=models.SET_NULL, null=True)
    CPU = models.CharField(max_length=50, null=True, blank=True)
    GPU = models.CharField(max_length=50, null=True, blank=True)
    RAM = models.CharField(max_length=50, null=True, blank=True)
    status = models.ForeignKey('ItemStatus', on_delete=models.SET_NULL, null=True)
    onsite = models.CharField(max_length=50, null=True, blank=True)
    audit = models.CharField(max_length=50, null=True, blank=True)
    quantity = models.CharField(max_length=50, null=True, blank=True)
    location = models.CharField(max_length=50, null=True, blank=True)
    dateOut = models.CharField(max_length=50, null=True, blank=True)
    dateReturn = models.CharField(max_length=50, null=True, blank=True)
    description = models.TextField(null=True, blank=True)
    comments = models.TextField(null=True, blank=True)
    user = models.ForeignKey(User, on_delete=models.SET_NULL, null=True, blank=True)
    
    
    def __str__(self):
        return self.name
   
class Booking(models.Model):
    item = models.ForeignKey(Item, on_delete=models.CASCADE)
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    start_date = models.DateField()
    start_time = models.TimeField()
    end_date = models.DateField()
    end_time = models.TimeField()
    is_overdue = models.BooleanField(default=False)

    def __str__(self):
        return f"Booking for {self.item} by {self.user.username} ({self.start_date} {self.start_time} to {self.end_date} {self.end_time})"



class ItemType(models.Model):
    type = models.CharField(max_length=200)

    def __str__(self):
        return self.type

class ItemStatus(models.Model):
    status = models.CharField(max_length=100)

    def __str__(self):
        return self.status

    
