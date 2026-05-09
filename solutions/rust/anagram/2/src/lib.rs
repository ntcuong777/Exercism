use std::collections::HashSet;

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let word = word.to_lowercase();
    let mut anagrams = HashSet::new();

    for &candidate in possible_anagrams.iter() {
        let candidate_lower = candidate.to_lowercase();
        if candidate_lower.len() == word.len() && candidate_lower != word {
            let mut word_chars: Vec<char> = word.chars().collect();
            let mut candidate_chars: Vec<char> = candidate_lower.chars().collect();
            word_chars.sort_unstable();
            candidate_chars.sort_unstable();

            if word_chars == candidate_chars {
                anagrams.insert(candidate);
            }
        }
    }

    anagrams
}
