from rest_framework import generics
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view
from amigosApp.models.amigos import Amigos
from amigosApp.serializers.amigosSerializer import AmigosSerializer

# class AmigosCreateView(generics.CreateAPIView):
#     serializer_class = AmigosSerializer
#     def post(self, request, *args, **kwargs):
#         amigos_serializer = AmigosSerializer(data=request.data)
#         if amigos_serializer.is_valid(raise_exception=True):
#             amigos_serializer.save()
#         data = {
#             'Amigo agregado en el sistema',
#         }
#         return Response(data, status=status.HTTP_201_CREATED)

@api_view(['GET', 'PUT', 'DELETE'])
def amigos_detail_view(request, pk=None):
    try:
        amigos = Amigos.objects.get(pk=pk)
    except Amigos.DoesNotExist:
        return Response('Amigo no encontrado', status=status.HTTP_404_NOT_FOUND)

    if request.method == 'GET':
        amigos_serializer = AmigosSerializer(amigos)
        return Response(amigos_serializer.data)

    elif request.method == 'PUT':
        amigos_serializer = AmigosSerializer(amigos, data=request.data)
        if amigos_serializer.is_valid():
            amigos_serializer.save()
            return Response(amigos_serializer.data)
        return Response(amigos_serializer.errors)

    elif request.method == 'DELETE':
        amigos.delete()
        return Response('Amigo eliminado')

class AmigosListAPIView(generics.ListAPIView):
    serializer_class = AmigosSerializer

    def get_queryset(self):
        return Amigos.objects.all()

class AmigosFilterList(generics.ListCreateAPIView):
    queryset = Amigos.objects.all()
    serializer_class = AmigosSerializer
    name = 'Amigos-filter'
    filter_fields = (
        'cliente',
    )