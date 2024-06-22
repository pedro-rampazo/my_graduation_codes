<x-app-layout>
    <x-slot name="header">
        <h2 class="font-semibold text-xl text-gray-800 leading-tight">
            {{ __('Add') }}
        </h2>
    </x-slot>

    <div class="py-12">
        <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
            <div class="bg-white overflow-hidden shadow-sm sm:rounded-lg">
                <div class="p-6 text-gray-900">
                    <form action="/add" method="post">
                        @csrf
                        <div>
                            <x-input-label for="title" :value="__('Title')" />
                            <x-text-input id="title" class="block mt-1 w-full" type="text" name="title" :value="old('title')" required autofocus autocomplete="title" />
                            <x-input-error :messages="$errors->get('title')" class="mt-2" />
                        </div>

                        <div>
                            <x-input-label for="year" :value="__('Year')" />
                            <x-text-input id="year" class="block mt-1 w-full" type="number" name="year" :value="old('year')" required autofocus autocomplete="year" />
                            <x-input-error :messages="$errors->get('year')" class="mt-2" />
                        </div>

                        <div>
                            <x-input-label for="artist" :value="__('Artist')" />
                            <x-text-input id="Artist" class="block mt-1 w-full" type="text" name="artist" :value="old('artist')" required autofocus autocomplete="artist" />
                            <x-input-error :messages="$errors->get('artist')" class="mt-2" />
                        </div>

                        <div>
                            <x-input-label for="genre" :value="__('Genre')" />
                            <x-text-input id="genre" class="block mt-1 w-full" type="text" name="genre" :value="old('genre')" required autofocus autocomplete="genre" />
                            <x-input-error :messages="$errors->get('genre')" class="mt-2" />
                        </div>

                        <div>
                            <x-input-label for="label" :value="__('Label')" />
                            <x-text-input id="label" class="block mt-1 w-full" type="text" name="label" :value="old('label')" required autofocus autocomplete="label" />
                            <x-input-error :messages="$errors->get('label')" class="mt-2" />
                        </div>

                        <div class="flex items-center justify-end mt-4">
                            <x-primary-button class="ms-4">
                                {{ __('Add') }}
                            </x-primary-button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</x-app-layout>
