"""amigosProject URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from amigosApp.views import *
from authApp.views import *
from rest_framework_simplejwt.views import (TokenObtainPairView, TokenRefreshView)

urlpatterns = [
    path('admin/', admin.site.urls),
    path('login/', TokenObtainPairView.as_view()),
    path('refresh/', TokenRefreshView.as_view()),
    path('verifytoken/', VerifyTokenView.as_view()),
    path('user/', UserCreateView.as_view()), # Para crear usuarios
    path('user/lista/', UserListAPIView.as_view()),
    path('user/lista/<int:pk>/', user_detail_view), # Para consultar usuarios
    # path('amigos/', AmigosCreateView.as_view()),
    path('amigos/',AmigosFilterList.as_view()),
    path('amigos/lista/',AmigosListAPIView.as_view()),
    path('amigos/lista/<int:pk>/',amigos_detail_view),
]