package com.example.hashjfx;
//REF: https://stackoverflow.com/questions/14288185/detecting-windows-or-linux
public class OSChecker {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isLinux() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }
}
