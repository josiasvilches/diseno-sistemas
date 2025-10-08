from abc import ABC, abstractmethod
import math

# ============================================
# PRODUCTO ABSTRACTO - Clase base Triangulo
# ============================================

class Triangulo(ABC):
    """Clase abstracta que representa un triángulo genérico"""

    def __init__(self, lado_a: int, lado_b: int, lado_c: int):
        self._lado_a = lado_a
        self._lado_b = lado_b
        self._lado_c = lado_c

    # Getters y Setters
    @property
    def lado_a(self) -> int:
        return self._lado_a

    @lado_a.setter
    def lado_a(self, valor: int):
        self._lado_a = valor

    @property
    def lado_b(self) -> int:
        return self._lado_b

    @lado_b.setter
    def lado_b(self, valor: int):
        self._lado_b = valor

    @property
    def lado_c(self) -> int:
        return self._lado_c

    @lado_c.setter
    def lado_c(self, valor: int):
        self._lado_c = valor

    # Métodos abstractos que deben implementar las subclases
    @abstractmethod
    def get_descripcion(self) -> str:
        """Retorna la descripción del tipo de triángulo"""
        pass

    @abstractmethod
    def get_superficie(self, base: float, altura: float) -> float:
        """Calcula la superficie del triángulo"""
        pass

    @abstractmethod
    def dibujate(self) -> None:
        """Dibuja el triángulo (representación visual)"""
        pass

    def get_perimetro(self) -> int:
        """Calcula el perímetro del triángulo"""
        return self._lado_a + self._lado_b + self._lado_c

    def es_valido(self) -> bool:
        """Verifica si los lados forman un triángulo válido"""
        return (self._lado_a + self._lado_b > self._lado_c and
                self._lado_b + self._lado_c > self._lado_a and
                self._lado_a + self._lado_c > self._lado_b)


# ============================================
# PRODUCTOS CONCRETOS - Tipos de Triángulos
# ============================================

class Equilatero(Triangulo):
    """Triángulo con todos los lados iguales"""

    def __init__(self, lado_a: int, lado_b: int, lado_c: int):
        super().__init__(lado_a, lado_b, lado_c)

    def get_descripcion(self) -> str:
        return "Soy un triángulo Equilátero"

    def get_superficie(self, base: float = None, altura: float = None) -> float:
        """Calcula el área usando la fórmula para triángulo equilátero"""
        # Área = (√3 / 4) * lado²
        lado = self._lado_a
        return (math.sqrt(3) / 4) * (lado ** 2)

    def dibujate(self) -> None:
        """Representación visual del triángulo equilátero"""
        print("\n    /\\")
        print("   /  \\")
        print("  /    \\")
        print(" /______\\")
        print(f"Lados: {self._lado_a} = {self._lado_b} = {self._lado_c}")


class Isosceles(Triangulo):
    """Triángulo con dos lados iguales"""

    def __init__(self, lado_a: int, lado_b: int, lado_c: int):
        super().__init__(lado_a, lado_b, lado_c)

    def get_descripcion(self) -> str:
        return "Es un triángulo Isósceles"

    def get_superficie(self, base: float, altura: float) -> float:
        """Calcula el área usando base y altura"""
        return (base * altura) / 2

    def dibujate(self) -> None:
        """Representación visual del triángulo isósceles"""
        print("\n    /\\")
        print("   /  \\")
        print("  /    \\")
        print(" /______\\")
        print(f"Lados: {self._lado_a}, {self._lado_b}, {self._lado_c}")


class Escaleno(Triangulo):
    """Triángulo con todos los lados diferentes"""

    def __init__(self, lado_a: int, lado_b: int, lado_c: int):
        super().__init__(lado_a, lado_b, lado_c)

    def get_descripcion(self) -> str:
        return "Es un triángulo Escaleno"

    def get_superficie(self, base: float = None, altura: float = None) -> float:
        """Calcula el área usando la fórmula de Herón"""
        # s = (a + b + c) / 2
        # área = √(s(s-a)(s-b)(s-c))
        s = self.get_perimetro() / 2
        area = math.sqrt(s * (s - self._lado_a) * (s - self._lado_b) * (s - self._lado_c))
        return area

    def dibujate(self) -> None:
        """Representación visual del triángulo escaleno"""
        print("\n     /\\")
        print("    /  \\")
        print("   /    \\")
        print("  /______\\")
        print(f"Lados: {self._lado_a} ≠ {self._lado_b} ≠ {self._lado_c}")


# ============================================
# FACTORY METHOD - Interface
# ============================================

class TrianguloFactoryMethod(ABC):
    """Interface para el Factory Method"""

    @abstractmethod
    def create_triangulo(self, lado_a: int, lado_b: int, lado_c: int) -> Triangulo:
        """Método factory que crea instancias de triángulos"""
        pass


# ============================================
# FACTORY CONCRETO
# ============================================

class TrianguloFactory(TrianguloFactoryMethod):
    """Implementación concreta del Factory Method"""

    def create_triangulo(self, lado_a: int, lado_b: int, lado_c: int) -> Triangulo:
        """
        Crea el tipo correcto de triángulo basándose en los lados proporcionados.

        - Equilátero: todos los lados iguales
        - Escaleno: todos los lados diferentes
        - Isósceles: dos lados iguales
        """

        # Verificar si los lados forman un triángulo válido
        if not (lado_a + lado_b > lado_c and
                lado_b + lado_c > lado_a and
                lado_a + lado_c > lado_b):
            raise ValueError(f"Los lados {lado_a}, {lado_b}, {lado_c} no forman un triángulo válido")

        # Equilátero: todos los lados son iguales
        if (lado_a == lado_b) and (lado_b == lado_c) and (lado_a == lado_c):
            return Equilatero(lado_a, lado_b, lado_c)

        # Escaleno: todos los lados son diferentes
        elif (lado_a != lado_b) and (lado_b != lado_c) and (lado_a != lado_c):
            return Escaleno(lado_a, lado_b, lado_c)

        # Isósceles: dos lados iguales
        else:
            return Isosceles(lado_a, lado_b, lado_c)


# ============================================
# EJEMPLO DE USO
# ============================================

def main():
    print("=" * 60)
    print("PATRÓN FACTORY METHOD - SISTEMA DE TRIÁNGULOS")
    print("=" * 60)

    # Crear el factory
    factory = TrianguloFactory()

    # Caso 1: Triángulo Equilátero
    print("\n### CASO 1: Triángulo Equilátero ###")
    triangulo1 = factory.create_triangulo(10, 10, 10)
    print(triangulo1.get_descripcion())
    print(f"Perímetro: {triangulo1.get_perimetro()}")
    print(f"Superficie: {triangulo1.get_superficie():.2f}")
    triangulo1.dibujate()

    # Caso 2: Triángulo Isósceles
    print("\n\n### CASO 2: Triángulo Isósceles ###")
    triangulo2 = factory.create_triangulo(10, 10, 5)
    print(triangulo2.get_descripcion())
    print(f"Perímetro: {triangulo2.get_perimetro()}")
    print(f"Superficie (base=5, altura=9.68): {triangulo2.get_superficie(5, 9.68):.2f}")
    triangulo2.dibujate()

    # Caso 3: Triángulo Escaleno
    print("\n\n### CASO 3: Triángulo Escaleno ###")
    triangulo3 = factory.create_triangulo(7, 8, 9)
    print(triangulo3.get_descripcion())
    print(f"Perímetro: {triangulo3.get_perimetro()}")
    print(f"Superficie (Fórmula de Herón): {triangulo3.get_superficie():.2f}")
    triangulo3.dibujate()

    # Caso 4: Múltiples triángulos con el mismo factory
    print("\n\n### CASO 4: Creación de múltiples triángulos ###")
    triangulos = [
        (3, 3, 3),
        (5, 5, 8),
        (6, 7, 8),
        (4, 4, 4),
    ]

    for i, (a, b, c) in enumerate(triangulos, 1):
        print(f"\nTriángulo {i} - Lados: ({a}, {b}, {c})")
        try:
            triangulo = factory.create_triangulo(a, b, c)
            print(f"  → {triangulo.get_descripcion()}")
            print(f"  → Perímetro: {triangulo.get_perimetro()}")
        except ValueError as e:
            print(f"  ✗ Error: {e}")

    # Caso 5: Triángulo inválido
    print("\n\n### CASO 5: Manejo de triángulo inválido ###")
    try:
        triangulo_invalido = factory.create_triangulo(1, 2, 10)
    except ValueError as e:
        print(f"✗ Error capturado: {e}")

    print("\n" + "=" * 60)
    print("VENTAJAS DEL PATRÓN FACTORY METHOD:")
    print("=" * 60)
    print("✓ El cliente no necesita conocer las clases concretas")
    print("✓ La lógica de creación está centralizada")
    print("✓ Fácil extensión con nuevos tipos de triángulos")
    print("✓ Cumple con el principio Open/Closed")
    print("✓ Desacoplamiento entre creación y uso")
    print("=" * 60)


if __name__ == "__main__":
    main()