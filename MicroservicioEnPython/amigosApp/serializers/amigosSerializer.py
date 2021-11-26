from amigosApp.models.amigos import Amigos
from rest_framework import serializers

class AmigosSerializer (serializers.ModelSerializer):
    class Meta:
        model = Amigos
        fields = '__all__'

    def create(self, validated_data):
        amigo_instance = Amigos.objects.create(**validated_data)
        return amigo_instance

    def to_representation(self, instance):
        return{
            'id_amigo':instance.id_amigo,
            'nombre':instance.nombre,
            'apellidos':instance.apellidos,
            'email':instance.email,
            'telefono':instance.telefono,
            'cliente':instance.cliente.username
        }