from abc import ABC, abstractmethod
from typing import List
from datetime import datetime

# ============================================
# RECEPTOR - Interface y clases concretas de servidores
# ============================================

class IServer(ABC):
    """Interface que define las operaciones básicas de un servidor"""

    @abstractmethod
    def conectar(self) -> str:
        pass

    @abstractmethod
    def desconectar(self) -> str:
        pass

    @abstractmethod
    def encender(self) -> str:
        pass

    @abstractmethod
    def apagar(self) -> str:
        pass

    @abstractmethod
    def reiniciar(self) -> str:
        pass

    @abstractmethod
    def guardar_log(self, mensaje: str) -> None:
        pass


# Servidor Web concreto
class ServidorWeb(IServer):
    def __init__(self, nombre: str):
        self.nombre = nombre
        self.estado = "apagado"
        self.logs: List[str] = []

    def conectar(self) -> str:
        mensaje = f"[{self.nombre}] Estableciendo conexión SSH al servidor web..."
        self.guardar_log(mensaje)
        return mensaje

    def desconectar(self) -> str:
        mensaje = f"[{self.nombre}] Cerrando conexión SSH del servidor web..."
        self.guardar_log(mensaje)
        return mensaje

    def encender(self) -> str:
        self.estado = "encendido"
        mensaje = f"[{self.nombre}] Iniciando servicios Apache y Nginx..."
        self.guardar_log(mensaje)
        return mensaje

    def apagar(self) -> str:
        self.estado = "apagado"
        mensaje = f"[{self.nombre}] Deteniendo servicios web y guardando sesiones..."
        self.guardar_log(mensaje)
        return mensaje

    def reiniciar(self) -> str:
        mensaje = f"[{self.nombre}] Reiniciando servidor web y limpiando caché..."
        self.guardar_log(mensaje)
        return mensaje

    def guardar_log(self, mensaje: str) -> None:
        timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        self.logs.append(f"[{timestamp}] {mensaje}")

    def mostrar_logs(self) -> None:
        print(f"\n--- Logs de {self.nombre} ---")
        for log in self.logs:
            print(log)


# Servidor de Base de Datos concreto
class ServidorBaseDatos(IServer):
    def __init__(self, nombre: str):
        self.nombre = nombre
        self.estado = "apagado"
        self.logs: List[str] = []

    def conectar(self) -> str:
        mensaje = f"[{self.nombre}] Conectando vía puerto 3306 al servidor de BD..."
        self.guardar_log(mensaje)
        return mensaje

    def desconectar(self) -> str:
        mensaje = f"[{self.nombre}] Desconectando del servidor de BD..."
        self.guardar_log(mensaje)
        return mensaje

    def encender(self) -> str:
        self.estado = "encendido"
        mensaje = f"[{self.nombre}] Iniciando MySQL y cargando bases de datos..."
        self.guardar_log(mensaje)
        return mensaje

    def apagar(self) -> str:
        self.estado = "apagado"
        mensaje = f"[{self.nombre}] Ejecutando FLUSH TABLES y apagando MySQL..."
        self.guardar_log(mensaje)
        return mensaje

    def reiniciar(self) -> str:
        mensaje = f"[{self.nombre}] Reiniciando MySQL y optimizando tablas..."
        self.guardar_log(mensaje)
        return mensaje

    def guardar_log(self, mensaje: str) -> None:
        timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        self.logs.append(f"[{timestamp}] {mensaje}")

    def mostrar_logs(self) -> None:
        print(f"\n--- Logs de {self.nombre} ---")
        for log in self.logs:
            print(log)


# Servidor de Aplicaciones concreto
class ServidorAplicaciones(IServer):
    def __init__(self, nombre: str):
        self.nombre = nombre
        self.estado = "apagado"
        self.logs: List[str] = []

    def conectar(self) -> str:
        mensaje = f"[{self.nombre}] Estableciendo conexión al servidor de aplicaciones..."
        self.guardar_log(mensaje)
        return mensaje

    def desconectar(self) -> str:
        mensaje = f"[{self.nombre}] Cerrando conexión del servidor de aplicaciones..."
        self.guardar_log(mensaje)
        return mensaje

    def encender(self) -> str:
        self.estado = "encendido"
        mensaje = f"[{self.nombre}] Iniciando Tomcat y deployando aplicaciones..."
        self.guardar_log(mensaje)
        return mensaje

    def apagar(self) -> str:
        self.estado = "apagado"
        mensaje = f"[{self.nombre}] Deteniendo Tomcat y liberando recursos..."
        self.guardar_log(mensaje)
        return mensaje

    def reiniciar(self) -> str:
        mensaje = f"[{self.nombre}] Reiniciando Tomcat y recargando aplicaciones..."
        self.guardar_log(mensaje)
        return mensaje

    def guardar_log(self, mensaje: str) -> None:
        timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        self.logs.append(f"[{timestamp}] {mensaje}")

    def mostrar_logs(self) -> None:
        print(f"\n--- Logs de {self.nombre} ---")
        for log in self.logs:
            print(log)


# ============================================
# COMANDO - Interface y comandos concretos
# ============================================

class IComando(ABC):
    """Interface que define el contrato para todos los comandos"""

    @abstractmethod
    def ejecutar(self) -> None:
        pass

    @abstractmethod
    def deshacer(self) -> None:
        pass


# Comando para encender servidor
class ComandoEncender(IComando):
    def __init__(self, servidor: IServer):
        self.servidor = servidor

    def ejecutar(self) -> None:
        print("\n→ Ejecutando comando ENCENDER:")
        print(self.servidor.conectar())
        print(self.servidor.encender())
        print(self.servidor.desconectar())
        print("✓ Servidor encendido exitosamente")

    def deshacer(self) -> None:
        print("\n← Deshaciendo comando ENCENDER (apagando servidor):")
        print(self.servidor.conectar())
        print(self.servidor.apagar())
        print(self.servidor.desconectar())


# Comando para apagar servidor
class ComandoApagar(IComando):
    def __init__(self, servidor: IServer):
        self.servidor = servidor

    def ejecutar(self) -> None:
        print("\n→ Ejecutando comando APAGAR:")
        print(self.servidor.conectar())
        print(self.servidor.apagar())
        print(self.servidor.desconectar())
        print("✓ Servidor apagado exitosamente")

    def deshacer(self) -> None:
        print("\n← Deshaciendo comando APAGAR (encendiendo servidor):")
        print(self.servidor.conectar())
        print(self.servidor.encender())
        print(self.servidor.desconectar())


# Comando para reiniciar servidor
class ComandoReiniciar(IComando):
    def __init__(self, servidor: IServer):
        self.servidor = servidor

    def ejecutar(self) -> None:
        print("\n→ Ejecutando comando REINICIAR:")
        print(self.servidor.conectar())
        print(self.servidor.apagar())
        print(self.servidor.reiniciar())
        print(self.servidor.encender())
        print(self.servidor.desconectar())
        print("✓ Servidor reiniciado exitosamente")

    def deshacer(self) -> None:
        print("\n← Deshaciendo comando REINICIAR (volviendo al estado anterior):")
        print("(Reiniciar no tiene deshacer específico)")


# Comando macro (composición de comandos)
class ComandoMacro(IComando):
    def __init__(self, nombre: str):
        self.nombre = nombre
        self.comandos: List[IComando] = []

    def agregar_comando(self, comando: IComando) -> None:
        self.comandos.append(comando)

    def ejecutar(self) -> None:
        print(f"\n{'='*60}")
        print(f"Ejecutando MACRO: {self.nombre}")
        print(f"{'='*60}")
        for comando in self.comandos:
            comando.ejecutar()

    def deshacer(self) -> None:
        print(f"\n{'='*60}")
        print(f"Deshaciendo MACRO: {self.nombre}")
        print(f"{'='*60}")
        # Deshacer en orden inverso
        for comando in reversed(self.comandos):
            comando.deshacer()


# ============================================
# INVOCADOR - Quien ejecuta los comandos
# ============================================

class InvocadorComandos:
    """Invocador que ejecuta comandos y mantiene historial"""

    def __init__(self):
        self.historial: List[IComando] = []

    def ejecutar_comando(self, comando: IComando) -> None:
        comando.ejecutar()
        self.historial.append(comando)

    def deshacer_ultimo(self) -> None:
        if self.historial:
            comando = self.historial.pop()
            comando.deshacer()
        else:
            print("\n⚠ No hay comandos para deshacer")

    def mostrar_historial(self) -> None:
        print(f"\n{'='*60}")
        print("HISTORIAL DE COMANDOS")
        print(f"{'='*60}")
        if self.historial:
            for i, comando in enumerate(self.historial, 1):
                print(f"{i}. {comando.__class__.__name__}")
        else:
            print("(Historial vacío)")
        print(f"{'='*60}")


# ============================================
# EJEMPLO DE USO
# ============================================

if __name__ == "__main__":
    print("\n" + "="*60)
    print("SISTEMA DE GESTIÓN DE SERVIDORES - PATRÓN COMANDO")
    print("="*60)

    # Crear servidores
    servidor_web = ServidorWeb("WEB-SERVER-01")
    servidor_bd = ServidorBaseDatos("DB-SERVER-01")
    servidor_app = ServidorAplicaciones("APP-SERVER-01")

    # Crear invocador
    invocador = InvocadorComandos()

    # Crear comandos individuales
    print("\n### COMANDOS INDIVIDUALES ###")

    comando1 = ComandoEncender(servidor_web)
    invocador.ejecutar_comando(comando1)

    comando2 = ComandoEncender(servidor_bd)
    invocador.ejecutar_comando(comando2)

    comando3 = ComandoReiniciar(servidor_app)
    invocador.ejecutar_comando(comando3)

    # Mostrar historial
    invocador.mostrar_historial()

    # Crear comando macro
    print("\n\n### COMANDO MACRO ###")
    macro_inicio_sistema = ComandoMacro("Inicio Completo del Sistema")
    macro_inicio_sistema.agregar_comando(ComandoEncender(servidor_bd))
    macro_inicio_sistema.agregar_comando(ComandoEncender(servidor_app))
    macro_inicio_sistema.agregar_comando(ComandoEncender(servidor_web))

    invocador.ejecutar_comando(macro_inicio_sistema)

    # Deshacer último comando
    print("\n\n### FUNCIONALIDAD DESHACER ###")
    invocador.deshacer_ultimo()

    # Mostrar logs finales
    servidor_web.mostrar_logs()
    servidor_bd.mostrar_logs()
    servidor_app.mostrar_logs()

    print("\n" + "="*60)
    print("FIN DE LA DEMOSTRACIÓN")
    print("="*60)