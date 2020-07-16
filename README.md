# Welcome to MReplayer Project  
> Ordering and Replaying of Execution Traces of Distributed Systems in the Context of Model-driven Development

MReplayer is a model-level replayer of [Eclipse Papyrus for Real-time](https://eclipse.org/papyrus-rt/) (Papyrus-RT). Papyrus-RT is an Eclipse-based, open-source modelling development environment for UML-RT systems. Recently, an extension of Papyrus-RT has been developed that allows the development of distributed systems with [UML-RT](https://github.com/kjahed/papyrusrt-distribution)

Ordering and replaying of execution traces of distributed systems is a challenging problem. State-of-the-art approaches annotate the traces with logical or physical timestamps. However, both kinds of timestamps have their drawbacks, including increased trace size.
We examine the problem of determining consistent orderings of execution traces in the context of model-driven development of reactive distributed systems, that is, systems whose code has been generated from communicating state machine models. By leveraging key concepts of state machines and existing model analysis and transformation techniques, we propose an approach to collecting and reordering execution traces that does not rely on timestamps. 
We describe a prototype implementation of our approach and an evaluation.

A detailed description of the MReplayer can be found in our [MODELS 2020](https://github.com/MajidGitHubRepos/MReplayer/blob/master/MReplayer_Technical_paper.pdf) paper.

## A Demonstration Video
> The graphical user interface of our tool is developed on top of the   @drawio which uses mxGraph library. You can find more information in [Drawio in Github](https://github.com/jgraph/drawio).


[<p style="text-align:center;"><img src="https://i.ibb.co/nbM8rL6/You-Tube-icon.png" width="193" height="130"></p>](https://www.youtube.com/watch?v=Gi5auwV3L5o)


# Usage
Please note that we assume that [PapyrusRT-distribution](https://github.com/kjahed/papyrusrt-distribution) and [Eclipse Modeling Framework](https://www.eclipse.org/modeling/emf/) are avaiable on your system.
## Step 1 (Run PapyrusRT-distribution and Import the Project):

1. Open a terminal and execute  ```/home/papyrus-rt-devtest-latest/Papyrus-RT/eclipse```. Ubuntu users can run the Eclipse from the launcher menu at the left side of the desktop.

2. The Eclipse launcher will be shown, use the default workspace (i.e., /home/workspace) and press the Launch.

3. You can import the project inside your workspase simply from the ```File``` menue in Eclipse and then select ```import...```, and finally ```Archive File```.

4. Once the MReplayer imported successfuly, you can see the source code of MReplayer, as well as MDebugger and mxgraph projects. below is a brief    description of these projects: 
    ```
    MDebugger   --> contains the transfromations' scripts that allows to instument the model.
    mxgraph    --> provides webUI for MReplayer and allows the user to controll the replay and inspect values at any given time.
    ```
## Step 2 (Run the Model Instrumention): 
The transformations scripts are called by other project to perfrom the required transformation, however it is possible to modify and execute this script in standalone mode. Execute the trasformation script inside the Eclipse IDE, follow the below instruction:

1. Open ```MDebugger/StateChartDebugInstrument/EOLScripts```, then righ click on the "UMLRTInstrumentv0.1.eol" and select Run as -> RunConfiguration
    ![alt text](https://github.com/moji1/MDebugger/blob/master/StateChartDebugInstrument/Screenshots/Step1.png)
    
2. Create a new configuration under EOL program and make sure the source is set to "UMLRTInstrumentv0.1.eol"
    ![alt text](https://github.com/moji1/MDebugger/blob/master/StateChartDebugInstrument/Screenshots/Step2.png)
    
3. Select a Models tab in the dialog and add two model
    ![alt text](https://github.com/moji1/MDebugger/blob/master/StateChartDebugInstrument/Screenshots/Step3.png)
    
4. The DebugginAgent model always should have the following configuraion
    ![alt text](https://github.com/moji1/MDebugger/blob/master/StateChartDebugInstrument/Screenshots/Step4.png)

5. Configure the UMLRTModel to the model that you want to be transformed for debugging
    ![alt text](https://github.com/moji1/MDebugger/blob/master/StateChartDebugInstrument/Screenshots/Step5.png)

6. Finally, press the run and see the result in the eclipse console and result model. Now the software is ready to receive traces from clients at TCP port 8001.

## Step 3 (Run the Webserver): 
1. Open ```mxgraph/java```, then righ click on the "build.xml" file and select Run as -> Ant Build
    ![alt text](https://github.com/MajidGitHubRepos/MReplayer/blob/master/src/main/resources/Screenshots/mxgraph1.png)

2. Make sure "grapheditor" is sent as an argument    
     ![alt text](https://github.com/MajidGitHubRepos/MReplayer/blob/master/src/main/resources/Screenshots/mxgraph2.png)
   
3. Open ```http://localhost:8080/javascript/examples/grapheditor/www/index.html``` in your browser to the web interface of MReplayer
    ![alt text](https://github.com/MajidGitHubRepos/MReplayer/blob/master/src/main/resources/Screenshots/mxgraph3.png)

## Step 4 (Run the Instrumented System):
1. Open the instrumented model in [PapyrusRT-distribution](https://github.com/kjahed/papyrusrt-distribution) and generate the code. 
    ![alt text](https://github.com/MajidGitHubRepos/MReplayer/blob/master/src/main/resources/Screenshots/code1.png)
2. Create a "build" directory in ```~/workspace/[ProjectName]/src/``` and run the following commands:
    ```
    $ cd build
    $ cmake ..
    $ make
    ```
3. Create a configuration file for distribution in json format (e.g., map.json)
(note: more information can be obtained in [PapyrusRT-distribution](https://github.com/kjahed/papyrusrt-distribution))
    ![alt text](https://github.com/MajidGitHubRepos/MReplayer/blob/master/src/main/resources/Screenshots/code2.png)

4. Run the system:
    - Each capsule is assigned to a process
    - The top capsule calls the configuration file with ```-c```
     ```
     (e.g.,
    ./Debug__TopMain -i tcp://127.0.0.1:1111 -c map.json
    ./Debug__TopMain -i tcp://127.0.0.1:2222
    ./Debug__TopMain -i tcp://127.0.0.1:3333
    ./Debug__TopMain -i tcp://127.0.0.1:4444
    ./Debug__TopMain -i tcp://127.0.0.1:5555
     )
     ```

## Source code layout
    .
    ├──src
    |   ├── com.controller                # All files for Creating Abstract Interpreter and Synthesizing variable values
    |   ├── com.antler4AC                 # All files for performing Action Code analysis  
    |   ├── com.server                    # All files for receiving traces from distributed clients
    |   ├── com.umlrtParser               # All files for performing structural/behavioral static analysis and creating PES
    ├── JAR                               # All required JAR files that should be added to the project 
    ├── Experiments                   
    │   ├── Original                      # Original Models (including: Replication.zip, ParcelRouter.zip , ...)
    │   ├── PhysicalTimeStamp             # Models that annotate traces with timestamps (e.g., MDebugger)
    |   ├── VectorTime                    # Models that annotate traces with Vector-Time
    │   └── TimeStampFree                 # Models that use no timestamp
    └── MDebugger                     
    │   ├── DebuggerModel                 # The Debugging Agent which is developed using UML-RT  
    |   ├── Model_instrumentation         # All the developed script for the model transformation 
    |   ├── RealTimeLibs                  # All lib that should be added into the RTS directory
    │   └── MetaModels                    # All required metamodels for executing the transformation
    

## Background

The following links may provide useful resources regarding the UML-RT concepts, and using PapyrusRT.

[PapyrusRT Website](https://eclipse.org/papyrus-rt/)

[PapyrusRT Forums](https://www.eclipse.org/forums/index.php/f/314/)

[Getting Started with PapyrusRT](https://wiki.eclipse.org/Papyrus-RT/User/User_Guide/Getting_Started)

[UML-RT Language Concepts](https://pdfs.semanticscholar.org/7fae/fac63155a404e431c97201f89fc8c37a7d62.pdf)

[An executable formal semantics for UML-RT](https://link.springer.com/article/10.1007/s10270-014-0399-z)

[Distribution for UML-RT](https://github.com/kjahed/papyrusrt-distribution)
