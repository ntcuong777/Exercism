defmodule Username do
  def sanitize(username) do
    # ä becomes ae
    # ö becomes oe
    # ü becomes ue
    # ß becomes ss

    allow_fn = fn c ->
      case c do
        ?_ -> true
        c when ?a <= c and c <= ?z -> true
        _ -> false
      end
    end

    german_to_latin = fn c ->
      case c do
        ?ä -> ~c"ae"
        ?ö -> ~c"oe"
        ?ü -> ~c"ue"
        ?ß -> ~c"ss"
        _ -> [c]
      end
    end

    username
    |> Enum.map(german_to_latin)
    |> Enum.concat
    |> Enum.filter(allow_fn)
  end
end
