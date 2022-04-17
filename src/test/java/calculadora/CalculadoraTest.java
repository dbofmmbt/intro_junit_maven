package calculadora;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @DisplayName("Testa a soma de dois n�meros")
    @Test
    public void testSomaDoisNumeros() {
        int soma = calc.soma(4, 5);
        Assertions.assertEquals(9, soma);
    }

    @Nested
    class Divisao {
        @Test
        public void doisNumeros() {
            int divisao = calc.divisao(8, 4);
            assertTrue(divisao == 2);
        }

        @Test
        public void porZero() {
            try {
                int divisao = calc.divisao(8, 0);
                fail("Exce��o n�o lan�ada");
            } catch (ArithmeticException e) {
                assertEquals("/ by zero", e.getMessage());
            }
        }

        @Test
        public void porZeroComAssertThrows() {
            assertThrows(ArithmeticException.class, () -> calc.divisao(8, 0));
        }
    }

    @Nested
    class Subtracao {
        @Test
        void basica() {
            int result = calc.subtracao(5, 3);
            assertEquals(2, result);
        }

        @Test
        void negativo() {
            assertEquals(-3, calc.subtracao(-5, -2));
        }

        @Test
        void comZero() {
            assertEquals(5, calc.subtracao(5, 0));
        }
    }

    @Nested
    class Multiplicacao {
        @Test
        void basica() {
            assertEquals(15, calc.multiplicacao(5, 3));
        }

        @Test
        void porZero() {
            assertEquals(0, calc.multiplicacao(5, 0));
        }

        @Test
        void comNegativo() {
            assertEquals(-6, calc.multiplicacao(3, -2));
        }
    }

    @Nested
    class Somatoria {
        @Test
        void basica() {
            assertEquals(15, calc.somatoria(5));
        }

        @Test
        void zero() {
            assertEquals(0, calc.somatoria(0));
        }
    }

    @Nested
    class EhPositivo {
        @Test
        void numeroPositivo() {
            assertTrue(calc.ehPositivo(10));
        }

        @Test
        void numeroNegativo() {
            assertFalse(calc.ehPositivo(-10));
        }
    }

    @Nested
    class Compara {
        @Test
        void maiorMenor() {
            assertEquals(1, calc.compara(10, 5));
        }

        @Test
        void iguais() {
            assertEquals(0, calc.compara(5, 5));
        }

        @Test
        void menorMaior() {
            assertEquals(-1, calc.compara(5, 10));
        }
    }
}
