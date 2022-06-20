#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

int attempt;
char opt_qo;

int main()
{
    char* text[] = {"part_one.txt", "part_two.txt", "part_three.txt", "part_four.txt"};
    int i;

    playGame();

    if(playGame() != '1'){
        exit(0);
    }

    for(i = 0; i < 4; i++){
        readDoc(text[i]);
        getch();
    }

    hallRoom();

    return 0;
}

void playGame(){
    char opt;

    while(opt != '1' && opt != '2'){
        system("cls");
        readDoc("title.txt");
        printf("\n[1] Inicio \n[2] Sair \n");
        opt = getch();
    }

    return opt;
}

void readDoc(char arq_name[]){
    int c;
    FILE *file;

    system("cls");
    file = fopen(arq_name, "r");

    if (file){
        while ((c = getc(file)) != EOF)
            putchar(c);
        fclose(file);
    }
}

char selectOption(char* room_option[], int size_array){
    int i, key_int = 0;
    char key;

    for(i = 0; i < size_array; i++){
        printf("[%i] %s\n", i+1, room_option[i]);
    }

    printf("Escolha:\n");

    while(key_int < 1 || key_int > size_array){
        key = getch();
        key_int = key - '0';
    }
    return key;
}

int passwordSystem(){
    system("cls");
    int password, i;
    char* text[] = {"final_part_one.txt", "final_part_two.txt", "final_part_three.txt", "end.txt"};

    printf("Senha: _ _ _ _\n[0] Voltar\n");
    scanf("%d", &password);

    if(password != 2611 && password != 0){
        attempt++;

        if(attempt == 3){
            readDoc("game_over.txt");
            getch();
            readDoc("game_over_title.txt");
        }else{
            printf("Acesso negado!\nVoce tem mais %d tentativa(s)", 3-attempt);
            getch();
            bunkerRoom();
        }
    }else if(password == 0){
        bunkerRoom();
    }else{
        printf("Acesso concedido\n");
        getch();
        printf("Voce entrou no Bunker");
        getch();

        for(i = 0; i < 4; i++){
            readDoc(text[i]);
            getch();
        }

    }
}

void hallRoom(){
    system("cls");

    char* hall_option[] = {"Sala de Estar (Esquerda)", "Biblioteca (Direita)", "Bunker (Em frente)", "Jardim da Mansao (Saida)"};
    int size = sizeof(hall_option)/sizeof(hall_option[0]);
    char opt;

    readDoc("hall_room.txt");
    printf("\nHALL DE ENTRADA\n");
    printf("Ir Para:\n");
    opt = selectOption(hall_option, size);

    switch(opt){
        case '1':
            livingRoom();
            break;
        case '2':
            libraryRoom();
            break;
        case '3':
            bunkerRoom();
            break;
        case '4':
            exitOption();
            break;
    }
}

void bunkerRoom(){
    system("cls");

    char opt;
    char* bunker_option[] = {"Digitar Senha", "Voltar"};
    int size = sizeof(bunker_option)/sizeof(bunker_option[0]);
    int password;

    readDoc("lock.txt");
    printf("\nBUNKER\n");
    printf("BLOQUEADO!\nInteragir:\n");
    opt = selectOption(bunker_option, size);

    switch(opt){
        case '1':
            passwordSystem();
            break;
        case '2':
            hallRoom();
            break;
    }
}

void exitOption(){
    char opt;

    while(opt != 's' && opt != 'n'){
        system("cls");
        printf("Voce deseja realmente sair da mansao?\n[s] sim\n[n] nao\n");
        opt = getch();
    }

    switch(opt){
        case 's':
            readDoc("game_over.txt");
            getch();
            readDoc("zombie.txt");
            getch();
            readDoc("game_over_title.txt");
            break;
        case 'n':
            hallRoom();
    }
}

void livingRoom(){
    system("cls");

    char* living_room_option[] = {"Abajur", "Obra de Arte", "Quadro", "Voltar"};
    int size = sizeof(living_room_option)/sizeof(living_room_option[0]);
    char opt;

    readDoc("living_room.txt");
    printf("\nSALA DE ESTAR\n");
    printf("Interagir:\n");
    opt = selectOption(living_room_option, size);

    switch(opt){
        case '1':
            system("cls");
            readDoc("lamp.txt");
            getch();
            printf("A luz foi apagada\n");
            getch();
            printf("- 'Os empregados mantinham as luzes acesas antes de serem... Deixa para la...' ");
            getch();
            livingRoom();
            break;
        case '2':
            system("cls");
            readDoc("sculpture.txt");
            getch();
            printf("San Giovanni Evangelista, Donatello (1415) - Releitura\n");
            getch();
            printf("- 'O tio gostava muito de obras de arte, dizia que te-las em casa era como negar a ignorancia...' ");
            getch();
            livingRoom();
            break;
        case '3':
            system("cls");
            readDoc("painting.txt");
            getch();
            printf("A Criacao de Eva, Michelangelo (1510)\n");
            getch();
            printf("- 'Como explicar tamanha surpresa? Um cientista com uma retratacao criacionista em sua sala...' ");
            getch();
            livingRoom();
            break;
        case '4':
            hallRoom();
            break;
    }
}

void libraryRoom(){
    system("cls");

    char* library_option[] = {"Gaveta da Mesa", "Estante de Livros", "Voltar"};
    int size = sizeof(library_option)/sizeof(library_option[0]);
    char opt;

    readDoc("library.txt");
    printf("\nBIBLIOTECA\n");
    printf("Interagir:\n");
    if(opt_qo == '4'){
        library_option[1] = "Necroterio (Acesso Secreto)";
    }
    opt = selectOption(library_option, size);

    switch(opt){
        case '1':
            system("cls");
            readDoc("drawer.txt");
            getch();
            printf("Achou um bilhete\n");
            getch();
            printf("Dica: 'Se nao es maquiavelico, certamente es adepto ao liberalismo' ");
            getch();
            libraryRoom();
            break;
        case '2':
            if(opt_qo == '4'){
                morgueRoom();
                getch();
            }else{
                bookCase();
            }
            break;
        case '3':
            hallRoom();
            break;
    }

}

void bookCase(){
    system("cls");

    char* book_case_option[] = {"O Principe, Maquiavel", "Novos Ensaios Sobre o Entendimento Humano, John Locke", "Voltar"};
    char* question_option[] = {"Torre Eiffel", "Cristo Redentor", "Muralha da China", "Torre de Pisa", "Esfinge"};
    int size_qo = sizeof(question_option)/sizeof(question_option[0]);
    int size = sizeof(book_case_option)/sizeof(book_case_option[0]);
    char opt, answer[20];

    readDoc("book_shelf.txt");
    getch();
    printf("\n- 'Essa estante eh muito estranha, tio Baltazar costumava mexer muito nela... Ele sempre dizia que os livros abriam muitas portas...'\n");
    getch();
    opt = selectOption(book_case_option, size);

    switch(opt){
        case '1':
            system("cls");
            printf("Eu sou eu quando voce nao sabe quem sou\nmas quando voce sabe quem sou\neu nao sou mais\nQuem sou eu?\n");
            scanf("%s", &answer);
            if(strcmp(answer, "enigma") == 0){
                printf("Voce Acertou\n");
                getch();
                printf("Nada Aconteceu\n");
            }else{
                printf("Voce Errou\n");
            }
            getch();
            bookCase();
            break;
        case '2':
            system("cls");
            printf("Qual monumento eh famoso pela sua inclinacao?\n");
            opt_qo = selectOption(question_option, size_qo);

            if(opt_qo == '4'){
                system("cls");
                printf("Voce Acertou\n");
                getch();
                printf("Voce abriu uma passagem secreta");
                getch();
                libraryRoom();
            }else{
                system("cls");
                printf("Voce Errou\n");
                getch();
                bookCase();
            }
            break;
        case '3':
            libraryRoom();
            break;
    }
}

void morgueRoom(){
    system("cls");

    char* morgue_option[] = {"Cadaver", "Relatorio do Corpo", "Voltar"};
    int size = sizeof(morgue_option)/sizeof(morgue_option[0]);
    char opt, opt_sn;

    printf("Dica: 'A resposta eh a quantidade de coisas que ninguem ousaria examinar' - Tio Baltazar\n");
    printf("NECROTERIO\n");
    printf("Interagir:\n");
    opt = selectOption(morgue_option, size);

    switch(opt){
        case '1':
            system("cls");
            readDoc("corpse.txt");
            getch();
            printf("\nDeseja colocar a mao dentro do corpo do cadaver?\n[s] sim\n[n] nao\n");
            while(opt_sn != 's' && opt_sn != 'n'){
                opt_sn = getch();
            }
            system("cls");
            if(opt_sn == 's'){
                printf("Voce colocou a mao no estomago do cadaver\n");
                getch();
                printf("Nada encontrado\n");
                getch();
                printf("- 'Belo lugar para esconder uma senha, tio... Mas para piorar, nao esta aqui' ");
                getch();
            }
            morgueRoom();
            break;
        case '2':
            system("cls");
            printf("- 'Relatorio da autopsia - Partes em estado de necrose: 2 pulmoes; 6 dedos da mao; 1 figado; 1 braco' ");
            getch();
            morgueRoom();
            break;
        case '3':
            libraryRoom();
            break;
    }
}
