from abc import ABC, abstractmethod
from typing import Optional

# Interface que define el contrato para los aprobadores
class IAprobador(ABC):
    def __init__(self):
        self._siguiente: Optional[IAprobador] = None

    def establecer_siguiente(self, aprobador: 'IAprobador') -> 'IAprobador':
        """Establece el siguiente aprobador en la cadena"""
        self._siguiente = aprobador
        return aprobador

    @abstractmethod
    def procesar_solicitud(self, monto: float) -> str:
        """Procesa la solicitud de crédito"""
        pass

    def _puede_aprobar(self, monto: float) -> bool:
        """Determina si este aprobador puede aprobar el monto"""
        pass


# Clase concreta: Ejecutivo de Cuenta
class EjecutivoCuenta(IAprobador):
    def __init__(self, nombre: str):
        super().__init__()
        self.nombre = nombre
        self.limite_aprobacion = 10000

    def procesar_solicitud(self, monto: float) -> str:
        if monto <= self.limite_aprobacion:
            return f"✓ {self.nombre} (Ejecutivo de Cuenta) aprueba el crédito de ${monto:,.2f}"
        elif self._siguiente:
            return self._siguiente.procesar_solicitud(monto)
        else:
            return f"✗ No hay aprobador disponible para el monto ${monto:,.2f}"


# Clase concreta: Líder
class Lider(IAprobador):
    def __init__(self, nombre: str):
        super().__init__()
        self.nombre = nombre
        self.limite_aprobacion = 50000

    def procesar_solicitud(self, monto: float) -> str:
        if monto <= self.limite_aprobacion:
            return f"✓ {self.nombre} (Líder) aprueba el crédito de ${monto:,.2f}"
        elif self._siguiente:
            return self._siguiente.procesar_solicitud(monto)
        else:
            return f"✗ No hay aprobador disponible para el monto ${monto:,.2f}"


# Clase concreta: Gerente
class Gerente(IAprobador):
    def __init__(self, nombre: str):
        super().__init__()
        self.nombre = nombre
        self.limite_aprobacion = 100000

    def procesar_solicitud(self, monto: float) -> str:
        if monto <= self.limite_aprobacion:
            return f"✓ {self.nombre} (Gerente) aprueba el crédito de ${monto:,.2f}"
        elif self._siguiente:
            return self._siguiente.procesar_solicitud(monto)
        else:
            return f"✗ No hay aprobador disponible para el monto ${monto:,.2f}"


# Clase concreta: Director
class Director(IAprobador):
    def __init__(self, nombre: str):
        super().__init__()
        self.nombre = nombre

    def procesar_solicitud(self, monto: float) -> str:
        # El Director puede aprobar cualquier monto
        return f"✓ {self.nombre} (Director) aprueba el crédito de ${monto:,.2f}"


# Cliente - Clase que solicita el crédito
class SolicitudCredito:
    def __init__(self, cliente: str, monto: float):
        self.cliente = cliente
        self.monto = monto

    def procesar(self, aprobador: IAprobador) -> str:
        print(f"\n{'='*60}")
        print(f"Cliente: {self.cliente}")
        print(f"Monto solicitado: ${self.monto:,.2f}")
        print(f"{'='*60}")
        resultado = aprobador.procesar_solicitud(self.monto)
        print(resultado)
        print(f"{'='*60}")
        return resultado


# Ejemplo de uso
if __name__ == "__main__":
    # Crear la cadena de responsabilidad
    ejecutivo = EjecutivoCuenta("Juan Pérez")
    lider = Lider("María González")
    gerente = Gerente("Carlos Rodríguez")
    director = Director("Ana Martínez")

    # Establecer la cadena
    ejecutivo.establecer_siguiente(lider).establecer_siguiente(gerente).establecer_siguiente(director)

    print("\n" + "="*60)
    print("SISTEMA DE APROBACIÓN DE CRÉDITOS - BANCO")
    print("="*60)

    # Casos de prueba
    solicitudes = [
        SolicitudCredito("Pedro López", 5000),      # Ejecutivo
        SolicitudCredito("Laura Díaz", 25000),      # Líder
        SolicitudCredito("Roberto Silva", 75000),   # Gerente
        SolicitudCredito("Sofía Castro", 150000),   # Director
        SolicitudCredito("Miguel Torres", 9999),    # Ejecutivo (límite)
        SolicitudCredito("Carmen Ruiz", 50000),     # Líder (límite)
    ]

    for solicitud in solicitudes:
        solicitud.procesar(ejecutivo)

    print("\n" + "="*60)
    print("FIN DEL PROCESAMIENTO")
    print("="*60)