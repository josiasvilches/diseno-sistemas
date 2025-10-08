from abc import ABC, abstractmethod
from typing import List
from datetime import datetime

# ============================================
# OBSERVER - Interface de Observadores
# ============================================

class ILibroMalEstado(ABC):
    """Interface que deben implementar todos los observadores"""

    @abstractmethod
    def update(self, libro: 'Libro') -> None:
        """Método que se ejecuta cuando se notifica al observador"""
        pass


# ============================================
# SUBJECT - Interface del Sujeto Observable
# ============================================

class Subject(ABC):
    """Interface para el sujeto que será observado"""

    @abstractmethod
    def attach(self, observer: ILibroMalEstado) -> None:
        """Agrega un observador a la lista"""
        pass

    @abstractmethod
    def detach(self, observer: ILibroMalEstado) -> None:
        """Remueve un observador de la lista"""
        pass

    @abstractmethod
    def notify_observers(self, libro: 'Libro') -> None:
        """Notifica a todos los observadores"""
        pass


# ============================================
# CONCRETE SUBJECT - Alarma de Libro
# ============================================

class AlarmaLibro(Subject):
    """Sujeto concreto que gestiona los observadores y las notificaciones"""

    def __init__(self):
        self._observadores: List[ILibroMalEstado] = []

    def attach(self, observer: ILibroMalEstado) -> None:
        """Agrega un observador si no está ya registrado"""
        if observer not in self._observadores:
            self._observadores.append(observer)
            print(f"✓ Observador {observer.__class__.__name__} registrado")

    def detach(self, observer: ILibroMalEstado) -> None:
        """Remueve un observador de la lista"""
        if observer in self._observadores:
            self._observadores.remove(observer)
            print(f"✗ Observador {observer.__class__.__name__} removido")

    def notify_observers(self, libro: 'Libro') -> None:
        """Notifica a todos los observadores registrados"""
        print(f"\n{'='*60}")
        print(f"ALERTA: Libro en mal estado detectado")
        print(f"Libro: {libro.titulo}")
        print(f"Estado: {libro.estado}")
        print(f"Notificando a {len(self._observadores)} departamento(s)...")
        print(f"{'='*60}\n")

        for observador in self._observadores:
            observador.update(libro)
            print()  # Línea en blanco entre notificaciones


# ============================================
# CONCRETE OBSERVERS - Observadores Concretos
# ============================================

class Compras(ILibroMalEstado):
    """Departamento de Compras - Observador concreto"""

    def update(self, libro: 'Libro') -> None:
        print("DEPARTAMENTO DE COMPRAS:")
        print(f"   → Solicito cotización de reparación o reposición del libro:")
        print(f"   → '{libro.titulo}'")
        print("   → Contactando proveedores...")
        print("   → Generando orden de compra...")


class Administracion(ILibroMalEstado):
    """Departamento de Administración - Observador concreto"""

    def update(self, libro: 'Libro') -> None:
        print("DEPARTAMENTO DE ADMINISTRACIÓN:")
        print(f"   → Libro dañado: '{libro.titulo}'")
        print("   → Suspensión de socio hasta la reposición o reparación")
        print("     del daño causado...")
        print("   → Registrando incidente en el sistema...")
        print("   → Enviando notificación al socio...")


class Stock(ILibroMalEstado):
    """Departamento de Stock - Observador concreto"""

    def update(self, libro: 'Libro') -> None:
        print("DEPARTAMENTO DE STOCK:")
        print(f"   → Libro: '{libro.titulo}'")
        print("   → Se da de baja al libro del inventario")
        print("   → Se manda a reparación o reposición...")
        print("   → Actualizando base de datos de inventario...")


# ============================================
# MODELO - Clase Libro
# ============================================

class Libro:
    """Representa un libro en la biblioteca"""

    def __init__(self, titulo: str = "", estado: str = "BUENO"):
        self._titulo = titulo
        self._estado = estado
        self._fecha_devolucion = None

    @property
    def titulo(self) -> str:
        return self._titulo

    @titulo.setter
    def titulo(self, valor: str):
        self._titulo = valor

    @property
    def estado(self) -> str:
        return self._estado

    @estado.setter
    def estado(self, valor: str):
        estados_validos = ["BUENO", "REGULAR", "MALO"]
        if valor.upper() in estados_validos:
            self._estado = valor.upper()
        else:
            raise ValueError(f"Estado inválido. Debe ser uno de: {estados_validos}")

    def __str__(self):
        return f"Libro('{self.titulo}', estado='{self.estado}')"


# ============================================
# CONTEXTO - Clase Biblioteca
# ============================================

class Biblioteca:
    """Gestiona las operaciones de la biblioteca"""

    def __init__(self, alarma: AlarmaLibro):
        self._alarma = alarma
        self._libros_devueltos = []

    def devuelve_libro(self, libro: Libro) -> None:
        """Procesa la devolución de un libro"""
        print(f"\nProcesando devolución del libro: '{libro.titulo}'")
        print(f"   Estado del libro: {libro.estado}")

        self._libros_devueltos.append(libro)

        if libro.estado == "MALO":
            print("   Libro en mal estado detectado!")
            print("   Activando sistema de alarmas...")
            self._alarma.notify_observers(libro)
        else:
            print("   ✓ Libro en buen estado")
            print("   ✓ Devolución procesada correctamente")

    def get_estadisticas(self) -> None:
        """Muestra estadísticas de libros devueltos"""
        total = len(self._libros_devueltos)
        malos = sum(1 for libro in self._libros_devueltos if libro.estado == "MALO")
        buenos = total - malos

        print(f"\n{'='*60}")
        print("ESTADÍSTICAS DE DEVOLUCIONES")
        print(f"{'='*60}")
        print(f"Total de libros devueltos: {total}")
        print(f"En buen estado: {buenos}")
        print(f"En mal estado: {malos}")
        print(f"{'='*60}")


# ============================================
# EJEMPLO DE USO
# ============================================

def main():
    print("=" * 60)
    print("PATRÓN OBSERVER - SISTEMA DE BIBLIOTECA")
    print("=" * 60)

    # Crear el sistema de alarmas (Subject)
    alarma = AlarmaLibro()

    # Registrar los observadores (departamentos)
    print("\n### REGISTRANDO OBSERVADORES ###\n")
    alarma.attach(Compras())
    alarma.attach(Administracion())
    alarma.attach(Stock())

    # Crear la biblioteca con el sistema de alarmas
    biblioteca = Biblioteca(alarma)

    # CASO 1: Devolución de libro en buen estado
    print("\n\n### CASO 1: Libro en buen estado ###")
    libro1 = Libro("El Quijote", "BUENO")
    biblioteca.devuelve_libro(libro1)

    # CASO 2: Devolución de libro en mal estado
    print("\n\n### CASO 2: Libro en mal estado ###")
    libro2 = Libro("Cien Años de Soledad", "MALO")
    biblioteca.devuelve_libro(libro2)

    # CASO 3: Otro libro en mal estado
    print("\n\n### CASO 3: Otro libro en mal estado ###")
    libro3 = Libro("1984", "MALO")
    biblioteca.devuelve_libro(libro3)

    # CASO 4: Libro en buen estado
    print("\n\n### CASO 4: Otro libro en buen estado ###")
    libro4 = Libro("Harry Potter y la Piedra Filosofal", "BUENO")
    biblioteca.devuelve_libro(libro4)

    # Mostrar estadísticas
    biblioteca.get_estadisticas()

    # Demostración de agregar/remover observadores dinámicamente
    print("\n\n### CASO 5: Modificación dinámica de observadores ###")
    print("\nRemoviendo el observador de Stock...")

    # Crear nuevos observadores para demostrar
    compras = Compras()
    administracion = Administracion()
    stock = Stock()

    # Crear nueva alarma para este ejemplo
    alarma2 = AlarmaLibro()
    alarma2.attach(compras)
    alarma2.attach(administracion)
    alarma2.attach(stock)

    print("\nRemoviendo Stock de los observadores...")
    alarma2.detach(stock)

    print("\nDevolviendo libro con menos observadores:")
    biblioteca2 = Biblioteca(alarma2)
    libro5 = Libro("El Principito", "MALO")
    biblioteca2.devuelve_libro(libro5)

    # Ventajas del patrón
    print("\n" + "=" * 60)
    print("VENTAJAS DEL PATRÓN OBSERVER:")
    print("=" * 60)
    print("✓ Desacoplamiento entre el sujeto y los observadores")
    print("✓ Se pueden agregar observadores sin modificar el sujeto")
    print("✓ Soporte para broadcast de notificaciones")
    print("✓ Los observadores reaccionan de forma independiente")
    print("✓ Fácil mantenimiento y extensión del sistema")
    print("=" * 60)


# Ejemplo adicional: Caso de la Bolsa de Valores
def ejemplo_bolsa_valores():
    """Ejemplo adicional mencionado en la teoría"""
    print("\n\n" + "=" * 60)
    print("EJEMPLO ADICIONAL: BOLSA DE VALORES")
    print("=" * 60)

    class IInversor(ABC):
        @abstractmethod
        def update(self, empresa: str, precio: float):
            pass

    class InversorConservador(IInversor):
        def update(self, empresa: str, precio: float):
            print(f"Inversor Conservador: Acciones de {empresa} a ${precio}")
            if precio < 100:
                print("   → Considerando vender para evitar pérdidas")

    class InversorAgresivo(IInversor):
        def update(self, empresa: str, precio: float):
            print(f"Inversor Agresivo: Acciones de {empresa} a ${precio}")
            if precio < 100:
                print("   → ¡Oportunidad! Comprando más acciones")

    class Empresa(IInversor):
        def update(self, empresa: str, precio: float):
            print(f"Empresa {empresa}: Precio de acción a ${precio}")
            if precio < 100:
                print("   → Analizando estrategias de recuperación")

    class BolsaValores(Subject):
        def __init__(self):
            self._inversores = []

        def attach(self, observer):
            self._inversores.append(observer)

        def detach(self, observer):
            self._inversores.remove(observer)

        def notify_observers(self, empresa: str, precio: float):
            print(f"\nCambio de precio detectado:")
            print(f"   Empresa: {empresa}, Nuevo precio: ${precio}\n")
            for inversor in self._inversores:
                inversor.update(empresa, precio)
                print()

    bolsa = BolsaValores()
    bolsa.attach(InversorConservador())
    bolsa.attach(InversorAgresivo())
    bolsa.attach(Empresa())

    print("\nSimulando caída de precio de acciones...")
    bolsa.notify_observers("TechCorp SA", 85.50)


if __name__ == "__main__":
    main()
    ejemplo_bolsa_valores()