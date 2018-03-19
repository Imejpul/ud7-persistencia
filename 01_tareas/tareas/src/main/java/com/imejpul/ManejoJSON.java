package com.imejpul;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class ManejoJSON {

    public void escribirEnJSON(List<String> tareas) {

        try {

            FileOutputStream fos = new FileOutputStream("listaTareas.json");
            Writer w = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String json = gson.toJson(tareas);
            w.write(json);

            w.flush();
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerDeJSON(List<String> tareas) {

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream("listaTareas.json"), StandardCharsets.UTF_8));

            String json = br.lines().collect(Collectors.joining());

            Gson gson = new Gson();

            tareas = gson.fromJson(json, tareas.getClass());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
