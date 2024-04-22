# path: /Users/imadhuddin/Desktop/djangoCw/appone/forms

from django import forms
from .models import Item
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserCreationForm

class CreateItemForm(forms.ModelForm):
    class Meta: 
        model = Item
        fields = '__all__'

class UpdateItemForm(forms.ModelForm):
    class Meta:
        model = Item
        fields = '__all__'