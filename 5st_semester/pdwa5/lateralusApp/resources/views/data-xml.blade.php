<?xml version="1.0" encoding="ISO-8859-1"?>
<data>
@foreach($registers as $album)
    <album>
        <title>{{ $album->title }}</title>
        <year>{{ $album->year }}</year>
        <artist>{{ $album->artist }}</artist>
        <genre>{{ $album->genre }}</genre>
        <label>{{ $album->label }}</label>
    </album>
@endforeach
</data>