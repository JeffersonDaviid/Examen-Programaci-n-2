package PkgFramework;

public class AppException extends Exception {

    public AppException(Throwable cause, Object className, String message) {
        System.out.println(
                "\nError causado por:\t" + cause +
                        "\nEn: \t\t\t" + className +
                        "\nMensaje:\t\t" + message);
    }

    public AppException(Throwable cause, Object className) {
        System.out.println(
                "\nError causado por:\t" + cause +
                        "\nEn: \t\t\t" + className);
    }

    public AppException(String message) {
        System.out.println("\nMensaje:\t\t" + message);
    }

}
