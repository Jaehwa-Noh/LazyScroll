[![KDoC](https://img.shields.io/badge/KDoc-7F52FF.svg?&style=for-the-badge&logo=kotlin&logoColor=white)](https://jaehwa-noh.github.io/LazyScroll/)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.jaehwa-noh/lazy-scroll?style=for-the-badge&logo=apache-maven&labelColor=C71A36
)](https://central.sonatype.com/artifact/io.github.jaehwa-noh/lazy-scroll)
[![javadoc](https://javadoc.io/badge2/io.github.jaehwa-noh/lazy-scroll/javadoc.svg)](https://javadoc.io/doc/io.github.jaehwa-noh/lazy-scroll)

# LazyScroll
Compose doesn't support scrollbar on lazy composables now days.   
https://developer.android.com/jetpack/androidx/compose-roadmap#core-libraries
![image](https://github.com/user-attachments/assets/fb45f948-c877-42f9-a21c-6fef1fd69008)



So that I made scrollbar for that composables.   
Enjoy your lazy composables with my scrollbar SDK.

Thank you.

## Usage
settings.gradle.kts
```kotlin dsl
pluginManagement {
    repositories {
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}
```

(module) build.gradle.kts
```kotlin dsl
dependencies {
    implementation("io.github.jaehwa-noh:lazy-scroll:1.0.0")
}
```

In the code
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HowToUseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    LazyListScrollbarHost(modifier = modifier) { lazyListState ->
        // If you need a horizontal scrollbar use LazyRow.
        // LazyRow(state = lazyListState) { }
        
        LazyColumn(state = lazyListState) {
            for (index in 0..100) {
                item {
                    Text(
                        text = "Hello $index!",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

```

### Demo video
#### Vertical
https://github.com/user-attachments/assets/c9b06f44-bee1-4db4-8017-e918cda7e92b

#### Horizontal
https://github.com/user-attachments/assets/ce012d2f-c216-43f5-a3f6-0d3d2fb42f16

### Spec
Support minSdkVersion >= 21  
Always good to use latest Compose version


## Roadmap

| Composable                  | support |
|-----------------------------|---------|
| LazyColumn                  | &#x2705;|
| LazyRow                     | &#x2705;|
| LazyVerticalGrid            | Planed  |
| LazyHorizontalGrid          | Planed  |
| LazyVerticalStaggeredGrid   | Planed  |
| LazyHorizontalStaggeredGrid | Planed  |

## Contribution
Always welcome to your contribution.

<br/>
<br/>

___

<br/>
<br/>

# 레이지스크롤
컴포즈는 현재 스크롤바를 지원하지 않습니다.   
https://developer.android.com/jetpack/androidx/compose-roadmap#core-libraries
![image](https://github.com/user-attachments/assets/e4b2ec39-c7c1-45aa-be9c-62620f498d02)

그래서 만들었습니다.   
당신의 레이지 컴포저블을 제 스크롤바 SDK로 편하게 사용하세요.

## 사용법
settings.gradle.kts
```kotlin dsl
pluginManagement {
    repositories {
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}
```

(모듈) build.gradle.kts
```kotlin dsl
dependencies {
    implementation("io.github.jaehwa-noh:lazy-scroll:1.0.0")
}
```

코드에서.
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HowToUseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    LazyListScrollbarHost(modifier = modifier) { lazyListState ->
        // 가로가 필요하면 LazyRow를 사용하세요.
        // LazyRow(state = lazyListState) { }
        
        LazyColumn(state = lazyListState) {
            for (index in 0..100) {
                item {
                    Text(
                        text = "Hello $index!",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}
```

### 시연 영상
#### 세로 방향
https://github.com/user-attachments/assets/c9b06f44-bee1-4db4-8017-e918cda7e92b

#### 가로 방향
https://github.com/user-attachments/assets/ce012d2f-c216-43f5-a3f6-0d3d2fb42f16

### 스펙
최소 SDK 버전 >= 21 지원  
언제나 최신 컴포즈 버전이 좋습니다.

## 계획

| 컴포저블                    | 지원    |
|-----------------------------|---------|
| LazyColumn                  | &#x2705;|
| LazyRow                     | &#x2705;|
| LazyVerticalGrid            | 계획    |
| LazyHorizontalGrid          | 계획    |
| LazyVerticalStaggeredGrid   | 계획    |
| LazyHorizontalStaggeredGrid | 계획    |

## 기여
당신의 기여는 언제나 환영합니다.
