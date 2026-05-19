class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.add(beginWord);

        for(String word : wordSet) {
            for(int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

                map.putIfAbsent(pattern, new ArrayList<>());
                map.get(pattern).add(word);
            }
        }

        Deque<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int steps = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String word = queue.poll();

                if(word.equals(endWord)) {
                    return steps;
                }

                for(int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    List<String> neighbors = map.getOrDefault(pattern, new ArrayList<>());

                    for(String n : neighbors) {
                        if(visited.contains(n)) {
                            continue;
                        }

                        queue.offer(n);
                        visited.add(n);
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}
