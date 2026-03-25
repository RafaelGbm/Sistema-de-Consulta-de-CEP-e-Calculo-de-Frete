# Para gerar as classes Java a partir do WSDL, execute:
#
mvn org.codehaus.mojo:jaxb2-maven-plugin:2.5.0:wsimport \
  -DwsdlUrl=http://localhost:8080/ws/endereco.wsdl \
  -DpackageName=com.example.consumer.wsdl

# Repita para o frete.wsdl se desejar:
#mvn org.codehaus.mojo:jaxb2-maven-plugin:2.5.0:wsimport \
#  -DwsdlUrl=http://localhost:8080/ws/frete.wsdl \
#  -DpackageName=com.example.consumer.wsdl
