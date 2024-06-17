from google.colab import drive
import matplotlib.pyplot as plt
import pandas as pd

# CARREGANDO DADOS DA PLANILHA
drive.mount("/content/drive")
file_path = '/content/drive/My Drive/registro_ocupacao_hospitalar_covid19_2020.csv'

# LENDO DADOS DA PLANILHA
registro = pd.read_csv(file_path)

# OBTENDO FREQUÊNCIA ABSOLUTA
frequencia_absoluta = registro["estado"].value_counts()
# OBTENDO FREQUÊNCIA RELATIVA
frequencia_relativa = registro["estado"].value_counts(normalize=True)

print(frequencia_absoluta)
print("=" * 100)
print(frequencia_relativa)
# PLOTANDO FREQUÊNCIA ABSOLUTA
plt.figure(figsize=(10, 7))
plt.hist(registro['estado'].astype(str), bins=len(frequencia_absoluta), edgecolor="black")
plt.title('Histograma de Estados com Internações')
plt.xlabel("Estado")
plt.ylabel("Frequência")
plt.xticks(rotation=90)  # Rotacionar os rótulos do eixo x para melhor visualização
plt.grid(axis='y', alpha=0.75)  # Adicionar grade ao eixo y
plt.tight_layout()
plt.show()
