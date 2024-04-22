
from django.urls import path
from . import views

urlpatterns = [
  
    path("equipmentView/", views.equipmentView, name = "equipmentView"),



]
