from rest_framework import generics
from amigosApp.models.amigos import Amigos
from amigosApp.serializers.amigosSerializer import AmigosSerializer

class AmigosListAPIView(generics.ListAPIView):
    serializer_class = AmigosSerializer

    def get_queryset(self):
        return Amigos.objects.all()