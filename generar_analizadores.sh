
#!/bin/bash
echo -e "\n"
echo "++++++++++++++++++++++++++++++++++++Inicio generacion con JFlex++++++++++++++++++++++++++++++++++++";
java -jar ./JFlex.jar -d src/Tiny/ lexico.flex
echo "++++++++++++++++++++++++++++++++++++FIN generacion con JFlex++++++++++++++++++++++++++++++++++++";
echo -e "\n"
echo -e "\n"
echo "++++++++++++++++++++++++++++++++++++Inicio generacion con CUP++++++++++++++++++++++++++++++++++++";
java -jar ./java-cup-11a.jar -destdir src/Tiny/ sintactico.cup
echo "++++++++++++++++++++++++++++++++++++FIN generacion con CUP++++++++++++++++++++++++++++++++++++";