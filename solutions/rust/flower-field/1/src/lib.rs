const DY: [i32; 8] = [-1, -1, -1, 0, 1, 1, 1, 0];
const DX: [i32; 8] = [-1, 0, 1, 1, 1, 0, -1, -1];

pub fn annotate(garden: &[&str]) -> Vec<String> {
    let n = garden.len() as i32;
    let m = garden.get(0).unwrap_or(&"").len() as i32;
    let byte_at_idx = |i: i32, j: i32| -> Option<u8> {
        if i < n && j < m && i >= 0 && j >= 0 {
            Some(garden[i as usize].as_bytes()[j as usize])
        } else {
            None
        }
    };

    garden
        .iter()
        .enumerate()
        .map(|(i, row)| {
            String::from_utf8(
                row.as_bytes()
                    .iter()
                    .enumerate()
                    .map(|(j, &b)| {
                        if b == b'*' {
                            b
                        } else {
                            let num_flowers = (0..8)
                                .filter_map(|k| {
                                    let ni = i as i32 + DY[k];
                                    let nj = j as i32 + DX[k];
                                    let b = byte_at_idx(ni, nj);
                                    match b {
                                        Some(b'*') => Some(1),
                                        _ => None,
                                    }
                                })
                                .sum::<i32>();
                            if num_flowers > 0 {
                                b'0' + num_flowers as u8
                            } else {
                                b
                            }
                        }
                    })
                    .collect::<Vec<u8>>(),
            )
            .unwrap()
        })
        .collect::<Vec<String>>()
}
