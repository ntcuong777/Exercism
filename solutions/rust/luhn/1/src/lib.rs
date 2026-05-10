/// Check a Luhn checksum.
pub fn is_valid(code: &str) -> bool {
    let luhn_sum = code
        .as_bytes()
        .iter()
        .filter(|&&b| b.is_ascii_digit())
        .rev()
        .enumerate()
        .map(|(i, &b)| {
            let n = (b - b'0') as u32;
            if i % 2 == 0 {
                n
            } else {
                let double_n = n * 2;
                if double_n > 9 {
                    double_n - 9
                } else {
                    double_n
                }
            }
        })
        .sum::<u32>();
    if luhn_sum % 10 == 0 {
        true
    } else {
        false
    }
}
