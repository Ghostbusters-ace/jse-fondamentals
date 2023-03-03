package fr.aelion.repositories;

import fr.aelion.helpers.CaseConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Repository<T> {

    private Class<T> model;
    private String simpleName;

    protected Repository(Class<T> className) {
        this.model = className;
        this.simpleName = model.getSimpleName().toLowerCase();
    }

    protected String getTableName() {
       /* var simpleName = this.getClass().getSimpleName();
        var repositoryPosition = simpleName.indexOf("Repository");*/
        // var simpleName =model.getSimpleName();

        return simpleName.toLowerCase();
    }

    protected String getAliasedTableName() {

        return getTableName() + " " + getTableName().substring(0, 1);
    }

    protected String[] getFields() {
        var current = model;
        var stringFields = new ArrayList<String>();

        while(current.getSuperclass() != null) {
            // Let's do stuff
            stringFields.addAll(
                    Arrays.asList(
                            Arrays.stream(current.getDeclaredFields())
                                    .map(f -> f.getName())
                                    .collect(Collectors.toSet())
                                    .toArray(new String[0])
                    )
            );
            current = (Class<T>) current.getSuperclass();
        }

        return stringFields.toArray(new String[0]);

        //return Arrays.stream(fields).map(f -> f.getName()).collect(Collectors.toSet()).toArray(new String[0]);
    }

    protected String getCommaSeparatedColumns() {

        String comma = "";
        String [] fields = getFields();
        Arrays.sort(fields);

        for (String f : fields
        ) {
            comma += simpleName.substring(0,1) + "." +CaseConverter.camelToSnake(f) + ",";
        }

        return comma.substring(0,comma.length()-1);
/*
        String[] fieldNames = this.getFields();

        String[] columnNames = Arrays.stream(fieldNames)
                .map(f -> simpleName.substring(0, 1) + "." + CaseConverter.camelToSnake(f))
                .collect(Collectors.toSet())
                .toArray(new String[0]);

        Arrays.sort(columnNames);

        return String.join(",", columnNames);*/
    }

    protected String getSelectQuery() {
        return String.format("SELECT %s FROM %s",
                getCommaSeparatedColumns(), getAliasedTableName());
    }
}
