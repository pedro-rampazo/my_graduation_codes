<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Album;

class AddController extends Controller
{
    public function save (Request $request){
        $request->validate([
            "title" => "required|min:3|max:50",
            "year" => "required|integer",
            "artist" => "required|min:2|max:50",
            "genre" => "required|min:3|max:50",
            "label" => "required|min:3|max:50"
        ],
        [
            "title.required" => "Field must be at least 3 characters.",
            "year.required" => "Field must be integer value.",
            "artist.required" => "Field must be at least 2 characters.",
            "genre.required" => "Field must be at least 3 characters.",
            "label.required" => "Field must be at least 3 characters."
        ]);
        $album = new Album();
        $album->fill($request->all());
        $album->save();

        // dd($request);
        return view("registryadded");
    }
}
