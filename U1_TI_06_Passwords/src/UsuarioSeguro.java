public class UsuarioSeguro {

    private String nombreUsuario;
    private String password;

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario.isEmpty() ) {
            System.out.println("Ingresa un nombre del usuario");
        } else {
            this.nombreUsuario = nombreUsuario;
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            System.out.println("La contraseña debe tener al menos 8 caracteres.");
            return;
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneDigito = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int ascii = (int) c;
            if (ascii >= 65 && ascii <= 90) {
                tieneMayuscula = true;
            } else if (ascii >= 97 && ascii <= 122) {
                tieneMinuscula = true;
            } else if (ascii >= 48 && ascii <= 57) {
                tieneDigito = true;
            }
        }

        if (!tieneMayuscula) {
            System.out.println("La contraseña debe contener al menos una letra mayúscula.");
        }
        if (!tieneMinuscula) {
            System.out.println("La contraseña debe contener al menos una letra minúscula.");
        }
        if (!tieneDigito) {
            System.out.println("La contraseña debe contener al menos un dígito.");
        }

        if (tieneMayuscula && tieneMinuscula && tieneDigito) {
            this.password = password;
        }
    }

    public boolean autenticar(String intentPassword) {
        return this.password != null && this.password.equals(intentPassword);
    }

    public boolean estaInicializado() {
        return this.nombreUsuario != null && this.password != null;
    }
}
