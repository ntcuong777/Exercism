defmodule PaintByNumber do
  defp find_min_bit_size(n, count) do
    if 2 ** n < count do
      find_min_bit_size(n + 1, count)
    else
      n
    end
  end

  def palette_bit_size(color_count) do
    find_min_bit_size(1, color_count)
  end

  def empty_picture(), do: <<>>

  def test_picture(), do: <<0::2, 1::2, 2::2, 3::2>>

  def prepend_pixel(picture, color_count, pixel_color_index) do
    bit_sz = palette_bit_size(color_count)
    <<pixel_color_index::size(bit_sz), picture::bitstring>>
  end

  def get_first_pixel(<<>>, _color_count), do: nil

  def get_first_pixel(picture, color_count) do
    bit_sz = palette_bit_size(color_count)
    <<pixel_color_index::size(^bit_sz), _rest::bitstring>> = picture
    pixel_color_index
  end

  def drop_first_pixel(<<>>, _color_count), do: <<>>

  def drop_first_pixel(picture, color_count) do
    bit_sz = palette_bit_size(color_count)
    <<_pixel_color_index::size(^bit_sz), rest::bitstring>> = picture
    rest
  end

  def concat_pictures(picture1, picture2) do
    <<picture1::bitstring, picture2::bitstring>>
  end
end
