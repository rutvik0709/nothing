import java.util.*;

public class temp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(scanner.nextInt());
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqA = frequencyMap.get(a);
                int freqB = frequencyMap.get(b);
                if (freqA != freqB) {
                    return freqB - freqA; 
                } else {
                    return list.indexOf(a) - list.indexOf(b);
                }
            }
        });

        for (int element : list) {
            System.out.print(element + " ");
        }

        scanner.close();
    }
}
