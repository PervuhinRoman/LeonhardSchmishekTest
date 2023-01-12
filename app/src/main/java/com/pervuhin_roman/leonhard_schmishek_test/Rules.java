package com.pervuhin_roman.leonhard_schmishek_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Rules {

    private final ArrayList<Trait> traits = new ArrayList<>();

    public Rules() {
        traits.add(hypertensive);
        traits.add(dysthymic);
        traits.add(cycloidal);
        traits.add(excitable);
        traits.add(stuck);
        traits.add(emotional);
        traits.add(exalted);
        traits.add(anxious);
        traits.add(pedantic);
        traits.add(demonstrative);
    }

    static class Trait {
        private final String name;
        private final int coefficient;
        private final Map<String, int[]> answers;

        public Trait(String name, int coefficient, Map<String, int[]> answers) {
            this.name = name;
            this.coefficient = coefficient;
            this.answers = answers;
        }

        public String getName() {
            return name;
        }

        public int getCoefficient() {
            return coefficient;
        }

        public Map<String, int[]> getAnswers() {
            return answers;
        }
    }

    // Гипертимность (Г)
    private final Map<String, int[]> table1 = new HashMap<>() {{
        put("true", new int[] {1, 11, 23, 33, 45, 55, 67, 77});
        put("false", new int[] {});
    }};
    Trait hypertensive = new Trait("Гипертимность", 3, table1);

    // Дистимность (В)
    private final Map<String, int[]> table2 = new HashMap<>() {{
        put("true", new int[] {9, 21, 43, 75, 87});
        put("false", new int[] {31, 53, 65});
    }};
    Trait dysthymic = new Trait("Дистимность", 3, table2);

    // Циклотимность (Ц)
    private final Map<String, int[]> table3 = new HashMap<>() {{
        put("true", new int[] {6, 18, 28, 40, 50, 62, 72, 84});
        put("false", new int[] {});
    }};
    Trait cycloidal = new Trait("Циклотимность", 3, table3);

    // Возбудимость (В)
    private final Map<String, int[]> table4 = new HashMap<>() {{
        put("true", new int[] {8, 20, 30, 42, 52, 64, 75, 86});
        put("false", new int[] {});
    }};
    Trait excitable = new Trait("Возбудимость", 3, table4);

    // Застревание (З)
    private final Map<String, int[]> table5 = new HashMap<>() {{
        put("true", new int[] {2, 15, 24, 34, 37, 56, 68, 78, 81});
        put("false", new int[] {12, 46, 59});
    }};
    Trait stuck = new Trait("Застревание", 2, table5);

    // Эмотивность (Эм)
    private final Map<String, int[]> table6 = new HashMap<>() {{
        put("true", new int[] {3, 13, 35, 47, 57, 69, 79});
        put("false", new int[] {25});
    }};
    Trait emotional = new Trait("Эмотивность", 3, table6);

    // Экзальтированность (Эк)
    private final Map<String, int[]> table7 = new HashMap<>() {{
        put("true", new int[] {10, 32, 54, 76});
        put("false", new int[] {});
    }};
    Trait exalted = new Trait("Экзальтированность", 6, table7);

    // Тревожность (Т)
    private final Map<String, int[]> table8 = new HashMap<>() {{
        put("true", new int[] {16, 27, 38, 49, 60, 71, 82});
        put("false", new int[] {5});
    }};
    Trait anxious = new Trait("Тревожность", 3, table8);

    // Педантичность (П)
    private final Map<String, int[]> table9 = new HashMap<>() {{
        put("true", new int[] {4, 14, 17, 26, 39, 48, 58, 61, 70, 80, 83});
        put("false", new int[] {36});
    }};
    Trait pedantic = new Trait("Педантичность", 2, table9);

    // Демонстративность (Де)
    private final Map<String, int[]> table10 = new HashMap<>() {{
        put("true", new int[] {7, 19, 22, 29, 41, 44, 63, 66, 73, 85, 88});
        put("false", new int[] {51});
    }};
    Trait demonstrative = new Trait("Демонстративность", 2, table10);

    public void checkAnswer(HashMap<String, Integer> results, int questionNumber, String answer) {

        for (Trait trait : this.traits) {
            ArrayList<Integer> itemNumbers = new ArrayList<>();

            for (Integer i : Objects.requireNonNull(trait.getAnswers().get(answer))) {
                itemNumbers.add(i);
            }

            if (itemNumbers.contains(questionNumber)) {
                System.out.println(trait.getName());

                int value = Objects.requireNonNull(results.get(trait.getName()));
                value+=trait.getCoefficient();
                results.put(trait.getName(), value);
            }
        }
    }
}

