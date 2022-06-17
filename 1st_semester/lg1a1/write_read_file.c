#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	FILE *file;
	char text[100], result[100];
	int c;

	file = fopen("write_file.txt", "w");

	printf("Type text: \n");
	fgets(text, 100, stdin);

	result[100] = fputs(text, file);
	if(result == EOF){
		printf("Error");
	}

	fclose(file);

	file = fopen("write_file.txt", "r");

	if(file){
		while((c = getc(file)) != EOF)
			putchar(c);
		fclose(file);
	}

}