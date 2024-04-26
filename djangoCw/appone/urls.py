
from django.urls import path
from . import views
from .views import cancel_booking

urlpatterns = [
  
    path("equipmentView/", views.equipmentView, name = "equipmentView"),
   path('book_item/<int:item_id>/', views.book_item, name='book_item'),
  path('bookings/', views.bookings_view, name='bookings_view'),
      path('historical/', views.historical, name='historical'),
    path('rebook/<int:item_id>/', views.rebook, name='rebook'),
     path('cancel_booking/<int:booking_id>/', cancel_booking, name='cancel_booking'),




]
