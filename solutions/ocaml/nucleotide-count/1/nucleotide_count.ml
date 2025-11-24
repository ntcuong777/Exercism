open Base

let empty = Map.empty (module Char)

let check_nucleotide c =
  match c with
  | 'A' | 'C' | 'G' | 'T' -> Ok ()
  | _ -> Error c

let check_nucleotides s =
  let rec aux i =
    if i >= String.length s then Ok ()
    else
      let curr_char = String.get s i in
      match check_nucleotide curr_char with
      | Error c -> Error c
      | Ok () -> aux (i + 1)
  in
  aux 0

let count_nucleotide s c =
  let check_s = check_nucleotides s in
  let check_c = check_nucleotide c in
  match check_s, check_c with
  | Ok (), Ok () ->
    if String.is_empty s then Ok 0
    else
      let rec aux i count =
        if i >= String.length s then Ok count
        else
          let curr_char = String.get s i in
          let count' = if Char.equal curr_char c then count + 1 else count
          in
          aux (i + 1) count'
      in
      aux 0 0
  | Ok (), Error c -> Error c
  | Error c, _ -> Error c

let count_nucleotides s =
  if String.is_empty s then Ok empty
  else
    let check_s = check_nucleotides s in
    match check_s with
    | Ok () ->
      Ok (
        List.map ~f:(fun c -> let v = count_nucleotide s c
                              in
                                match v with
                                | Ok cnt -> (c, cnt)
                                | Error _ -> (c, 0))
                  ['A'; 'C'; 'G'; 'T']
        |> Map.of_alist_exn (module Char)
        |> Map.filter ~f:(fun v -> v > 0)
      )
    | Error c -> Error c
