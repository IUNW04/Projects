# Generated by Django 4.2.3 on 2024-04-22 07:08

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('appone', '0005_item_id_alter_item_deviceserialnumber'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='item',
            name='is_booked',
        ),
    ]