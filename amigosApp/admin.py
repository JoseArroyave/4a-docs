from django.contrib import admin
from amigosApp.models.user import User
from amigosApp.models.amigos import Amigos

# Register your models here.
admin.site.register(User)
admin.site.register(Amigos)