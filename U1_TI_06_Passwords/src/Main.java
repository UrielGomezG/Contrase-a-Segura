import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioSeguro usuario = new UsuarioSeguro();

        System.out.println("Ingresa un usuario: ");
        String nombre = scanner.nextLine();

        usuario.setNombreUsuario(nombre);
        if(usuario.getNombreUsuario().isEmpty()){
            System.out.println("Ingresa un nombre del usuario");
            return;
        }else{
            String password;
            do {
                System.out.print("Ingresa una contraseña (mínimo 8 caracteres, 1 mayúscula, 1 minúscula, 1 dígito): ");
                password = scanner.nextLine();
                usuario.setPassword(password);

                if (usuario.getPassword() == null) {
                    System.out.println("Acceso denegado.");
                } else {
                    System.out.println("Acceso concedido.");
                     System.out.print("Verifica la contraseña (incorrecta): ");
                        String intentoIncorrecto = scanner.nextLine();
                        if (usuario.autenticar(intentoIncorrecto)) {
                        System.out.println("Acceso concedido.");
                        } else {
                        System.out.println("Acceso denegado.");
                    }

                     System.out.print("Verifica la contraseña (correcta): ");
                    String intentoCorrecto = scanner.nextLine();
                    if (usuario.autenticar(intentoCorrecto)) {
                        System.out.println("Acceso concedido.");
                     } else {
                         System.out.println("Acceso denegado.");
                }

                }

               
            } while (usuario.getPassword() == null);

        }


    }
}
