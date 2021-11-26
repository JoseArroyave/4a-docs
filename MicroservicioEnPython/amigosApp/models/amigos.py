from django.db import models
from authApp.models.user import User

class Amigos(models.Model):
    id_amigo = models.AutoField('id_amigo',primary_key=True)
    nombre = models.CharField('Nombre del amigo',max_length=60)
    apellidos = models.CharField('Apellidos del amigo',max_length=120)
    email = models.EmailField(default="No registra",blank=True)
    telefono = models.BigIntegerField(null=True, blank=True)
    cliente = models.ForeignKey(User,on_delete=models.CASCADE,null=False)

    def __str__(self):
        return f'[nombre:{self.nombre}, apellidos:{self.apellidos}]'