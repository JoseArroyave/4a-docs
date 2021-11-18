from django.db import models
from django.db.models.fields import AutoField
from amigosApp.models import User

class Amigos(models.Model):
    id = models.BigIntegerField(primary_key=True)
    nombre = models.CharField('Nombre del amigo',max_length=60)
    apellidos = models.CharField('Apellidos del amigo',max_length=120)
    email = models.EmailField(default="No registra",blank=True)
    telefono = models.BigIntegerField(null=True, blank=True)
    user = models.ForeignKey(User,related_name='user_amigo', on_delete=models.CASCADE)

   

    def __str__(self):
        return f'[nombre:{self.nombre}, apellidos:{self.apellidos}]'