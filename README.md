# Proyecto-ED-2020
Proyecto final para la materia Estructura de Datos [UNS]

___

### Minutas del proyecto

- Si bien la clave de acceso pretende funcionar mediante el formato AXA'A', donde A es el apellido del usuario, X es la letra 'X' y A' es el apellido pero invertido, el software implementado no corrobora que A sea efectivamente un apellido. Aún así, la eficacia es la misma.
- Tengo dudas con respecto a la implementacion de algunos metodos de Deque, de todas formas no son metodos relevantes para el funcionamiento del programa del proyecto.
- Utilizamos una Cola con Prioridad con Heap ya que los unicos metodos que usamos fueron insert() y min(), y este tipo de implementacion nos permite obtener la mayor eficiencia en ambos, tomando insert() O(log2(n)) y min() O(log2(n)).