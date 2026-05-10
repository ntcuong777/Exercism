#[derive(Debug, PartialEq, Eq)]
pub enum Comparison {
    Equal,
    Sublist,
    Superlist,
    Unequal,
}

pub fn is_sublist(sub: &[i32], main: &[i32]) -> bool {
    if sub.len() > main.len() {
        false
    } else if sub.is_empty() {
        true
    } else {
        main.windows(sub.len()).any(|window| window == sub)
    }
}

pub fn sublist(first_list: &[i32], second_list: &[i32]) -> Comparison {
    if first_list == second_list {
        Comparison::Equal
    } else if is_sublist(first_list, second_list) {
        Comparison::Sublist
    } else if is_sublist(second_list, first_list) {
        Comparison::Superlist
    } else {
        Comparison::Unequal
    }
}
