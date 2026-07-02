# Imagen base oficial de AWS sobre Alpine (Evita el bloqueo de límites de Docker Hub)
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17-alpine

RUN apk add --no-cache curl
VOLUME /tmp
EXPOSE 8080

# Nombre unificado con el buildspec.yml
ADD target/springboot-aws-deploy.jar springboot-aws-deploy.jar

ENTRYPOINT ["java","-jar","/springboot-aws-deploy.jar"]