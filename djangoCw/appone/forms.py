# path: /Users/imadhuddin/Desktop/djangoCw/appone/forms

from django import forms
from .models import Item
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserCreationForm
from .models import Booking




class BookingForm(forms.ModelForm):
    start_date = forms.DateField(label='Start Date')
    start_time = forms.TimeField(label='Start Time')
    end_date = forms.DateField(label='End Date')
    end_time = forms.TimeField(label='End Time')

    class Meta:
        model = Booking  # Correcting the reference to the Booking model
        fields = ['start_date', 'start_time', 'end_date', 'end_time']


   

class CreateItemForm(forms.ModelForm):
    class Meta: 
        model = Item
        fields = '__all__'

class UpdateItemForm(forms.ModelForm):
    class Meta:
        model = Item
        fields = '__all__'