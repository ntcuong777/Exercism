use std::collections::HashMap;

#[derive(Debug, PartialEq, Eq)]
pub enum Comparison {
    Equal,
    Sublist,
    Superlist,
    Unequal,
}

pub fn sublist(first_list: &[i32], second_list: &[i32]) -> Comparison {
    let mut counts_first: HashMap<i32, i32> = HashMap::new();
    let mut counts_second: HashMap<i32, i32> = HashMap::new();
    for &num in first_list {
        *counts_first.entry(num).or_insert(0) += 1;
    }
    for &num in second_list {
        *counts_second.entry(num).or_insert(0) += 1;
    }
    let is_first_contained = counts_second
        .iter()
        .all(|(num, count)| counts_first.get(num).unwrap_or(&0) >= count);
    let is_second_contained = counts_first
        .iter()
        .all(|(num, count)| counts_second.get(num).unwrap_or(&0) >= count);
    let is_equal =
        first_list.len() == second_list.len() && (is_first_contained || is_second_contained);
    if is_equal {
        Comparison::Equal
    } else if is_first_contained {
        Comparison::Superlist
    } else if is_second_contained {
        Comparison::Sublist
    } else {
        Comparison::Unequal
    }
}
