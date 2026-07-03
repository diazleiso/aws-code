# Imagen base oficial de AWS (Amazon Linux 2023) — tag confirmado estable en public ECR
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17

RUN yum install -y curl && yum clean all

VOLUME /tmp
EXPOSE 8080


# Nombre unificado con el buildspec.yml
ADD target/springboot-aws-deploy.jar springboot-aws-deploy.jar
ENTRYPOINT ["java","-jar","/springboot-aws-deploy.jar"]