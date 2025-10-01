class InstitutoEducativo:
    """
    Patrón Singleton para representar un instituto educativo único.
    Los clientes acceden a la única instancia mediante get_instance().
    """
    _instance = None

    def __init__(self):
        """
        Constructor privado (por convención).
        En Python no podemos hacer constructores realmente privados,
        pero la convención es que no se debe llamar directamente.
        """
        if InstitutoEducativo._instance is not None:
            raise Exception("Esta clase es un Singleton. Usa get_instance()")

        # Aquí irían las propiedades del instituto
        self.nombre = "Instituto Educativo XYZ"
        self.direccion = ""
        self.alumnos = []

    @staticmethod
    def get_instance():
        """
        Método estático que controla el acceso a la única instancia.
        Si la instancia no existe, la crea. Si ya existe, la retorna.
        """
        if InstitutoEducativo._instance is None:
            InstitutoEducativo._instance = InstitutoEducativo()
        return InstitutoEducativo._instance

def singleton(clase):
    """Decorador que convierte una clase en Singleton"""
    instancias = {}

    def get_instance(*args, **kwargs):
        if clase not in instancias:
            instancias[clase] = clase(*args, **kwargs)
        return instancias[clase]

    return get_instance

@singleton
class InstitutoEducativoV2:
    """Versión con decorador - más pythónica"""

    def __init__(self):
        self.nombre = "Instituto Educativo XYZ"
        self.direccion = ""
        self.alumnos = []

class SingletonMeta(type):
    """
    Metaclase que implementa el patrón Singleton.
    Esta es la forma más robusta en Python.
    """
    _instances = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super().__call__(*args, **kwargs)
        return cls._instances[cls]

class InstitutoEducativoV3(metaclass=SingletonMeta):
    """Versión con metaclase - más robusta"""

    def __init__(self):
        self.nombre = "Instituto Educativo XYZ"
        self.direccion = ""
        self.alumnos = []

if __name__ == "__main__":
    print("=" * 60)
    print("MÉTODO 1: Similar a Java")
    print("=" * 60)

    # Forma correcta: usando get_instance()
    instituto1 = InstitutoEducativo.get_instance()
    print(f"Instituto 1: {instituto1.nombre}")
    print(f"ID del objeto: {id(instituto1)}")

    # Si intentamos obtener otra instancia, obtenemos la misma
    instituto2 = InstitutoEducativo.get_instance()
    print(f"Instituto 2: {instituto2.nombre}")
    print(f"ID del objeto: {id(instituto2)}")

    # Verificamos que son el mismo objeto
    print(f"¿Son el mismo objeto? {instituto1 is instituto2}")

    # Si modificamos uno, se modifica el otro (porque son el mismo)
    instituto1.nombre = "Instituto Modificado"
    print(f"Nombre desde instituto2: {instituto2.nombre}")

    print("\n" + "=" * 60)
    print("MÉTODO 2: Con decorador")
    print("=" * 60)

    # Con el decorador, se usa directamente como constructor
    instituto3 = InstitutoEducativoV2()
    instituto4 = InstitutoEducativoV2()

    print(f"¿Son el mismo objeto? {instituto3 is instituto4}")
    print(f"ID del objeto 3: {id(instituto3)}")
    print(f"ID del objeto 4: {id(instituto4)}")

    print("\n" + "=" * 60)
    print("MÉTODO 3: Con metaclase")
    print("=" * 60)

    # Con metaclase también se usa como constructor normal
    instituto5 = InstitutoEducativoV3()
    instituto6 = InstitutoEducativoV3()

    print(f"¿Son el mismo objeto? {instituto5 is instituto6}")
    print(f"ID del objeto 5: {id(instituto5)}")
    print(f"ID del objeto 6: {id(instituto6)}")

    print("\n" + "=" * 60)
    print("NOTA: En Python, el intento de hacer new Instituto() ")
    print("directamente no funcionará correctamente con el Método 1.")
    print("Debes usar siempre get_instance().")
    print("=" * 60)