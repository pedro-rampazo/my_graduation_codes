from google.colab import drive
import matplotlib.pyplot as plt
import pandas as pd

# CARREGANDO DADOS DA PLANILHA
drive.mount("/content/drive")
file_path = '/content/drive/My Drive/registro_ocupacao_hospitalar_covid19_2020.csv'

# LENDO DADOS DA PLANILHA
df = pd.read_csv(file_path)

# Converter a coluna de datas para o tipo datetime
df['dataNotificacao'] = pd.to_datetime(df['dataNotificacao'])

# Filtrar dados apenas do ano de 2020
df_2020 = df[df['dataNotificacao'].dt.year == 2020]

# Gráfico de dispersão
plt.figure(figsize=(14, 8))
plt.scatter(df_2020['dataNotificacao'], df_2020['ocupacaoConfirmadoUti'], alpha=0.5)
plt.title('Gráfico de Dispersão da Ocupação Confirmada UTI em 2020')
plt.xlabel('Data de Notificação')
plt.ylabel('Ocupação Confirmada UTI')
plt.grid(True)
plt.show()
